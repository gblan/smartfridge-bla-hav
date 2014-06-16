package smartfridge.controller;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import smartfridge.enu.TypeProductEnum;
import smartfridge.fridge.Fridge;
import smartfridge.fridge.FridgeManager;
import smartfridge.product.ProductUnPerishable;
import smartfridge.view.AddingMenu;
import smartfridge.view.DetailMenu;
import smartfridge.view.MainMenu;
import smartfridge.view.PerishedView;

public class SwitchViewControler{

	private AddingMenu addingMenuView;
	private DetailMenu detailMenuView;
	private MainMenu mainMenuView;
	private PerishedView perishedMenuView;
	private static CardLayout cardlayout;
	private static JPanel mainPanel;
	
	private static FridgeManager fridge;
	
	

	public static final String ADDVIEW = "ADDVIEW";
	public static final String DETAILVIEW = "DETAILVIEW";
	public static final String MAINVIEW = "MAINVIEW";
	public static final String PERISHEDVIEW = "PERISHEDVIEW";

	public SwitchViewControler() {
		super();
		Fridge f = new Fridge();
		SwitchViewControler.fridge = new FridgeManager(f);
		fridge.addProduct(new ProductUnPerishable(TypeProductEnum.DRINKS,"coca", 1));
		this.addingMenuView = new AddingMenu(SwitchViewControler.fridge);
		this.detailMenuView = new DetailMenu(fridge);
		this.mainMenuView = new MainMenu(SwitchViewControler.fridge);
		this.perishedMenuView = new PerishedView(fridge);
		cardlayout = new CardLayout();
		SwitchViewControler.mainPanel = new JPanel(cardlayout);

	}

	public void buildCardLayout() {
		final JFrame frame = new JFrame("SmartFridge");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Build the panels
		mainPanel.add(MAINVIEW, mainMenuView);
		mainPanel.add(ADDVIEW, addingMenuView);
		mainPanel.add(DETAILVIEW, detailMenuView);
		mainPanel.add(PERISHEDVIEW, perishedMenuView);

		// Add components to the frame
		frame.add(mainPanel, BorderLayout.CENTER);

		// Display the frame
		frame.setSize(new Dimension(700, 500));
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		addListenerToPane();
	}

	public static void changePanel(String name) {
		cardlayout.show(mainPanel, name);
	}

	public void addListenerToPane() {
		this.mainMenuView.getLeftButtonMenuView().getAddingButton()
				.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						changePanel(ADDVIEW);
					}
				});
		
		this.mainMenuView.getLeftButtonMenuView().getCheckButton()
		.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(mainMenuView.getLeftButtonMenuView().getCheckIn().getText().matches("\\d+")){
					perishedMenuView.getRightControl().refreshDataPerished(Integer.parseInt(mainMenuView.getLeftButtonMenuView().getCheckIn().getText()));
					perishedMenuView.getLeftControl().refreshText(mainMenuView.getLeftButtonMenuView().getCheckIn().getText());
				}
				else{
					perishedMenuView.getRightControl().refreshDataPerished(0);
				}
				changePanel(PERISHEDVIEW);
			}
		});
		
		this.addingMenuView.getRightProductMenuView().getReturnButton()
		.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainMenuView.getRightProductMenuController().refreshData();
				changePanel(MAINVIEW);
			}
		});
		
		this.perishedMenuView.getLeftButtonMenuView().getMenuButton()
		.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainMenuView.getRightProductMenuController().refreshData();
				changePanel(MAINVIEW);
			}
		});
		
		this.detailMenuView.getLeftDetailMenuView().getReturnButton()
		.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainMenuView.getRightProductMenuController().refreshData();
				changePanel(MAINVIEW);
			}
		});
		
		this.addingMenuView.getRightProductMenuView().getValidationButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(addingMenuView.getRightAddMenuController().validationIsOk()){
					addingMenuView.getRightAddMenuController().addProduct();
					mainMenuView.getRightProductMenuController().refreshData();
					changePanel(MAINVIEW);
					
				}
			}
		});
	
		this.mainMenuView.getRightProductMenuView().getProductList().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2 ){
					detailMenuView.getLeftDetailMenuController().refreshData(mainMenuView.getRightProductMenuController().getSelectedProduct());
					detailMenuView.getRightProductMenuController().refreshData();
					changePanel(DETAILVIEW);
				}
				
			}
		});

			
	}



	
	

}
