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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import smartfridge.enu.TypeActionEnum;
import smartfridge.enu.TypeProductEnum;
import smartfridge.fridge.Fridge;
import smartfridge.fridge.FridgeManager;
import smartfridge.product.ProductUnPerishable;
import smartfridge.utils.FridgeUtils;
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
	
	private static FridgeManager fridgeManager;
	
	

	public static final String ADDVIEW = "ADDVIEW";
	public static final String DETAILVIEW = "DETAILVIEW";
	public static final String MAINVIEW = "MAINVIEW";
	public static final String PERISHEDVIEW = "PERISHEDVIEW";

	public SwitchViewControler() {
		super();
		Fridge f = new Fridge();
		SwitchViewControler.fridgeManager = new FridgeManager(f);		
		/* Chargement du frigo */
		fridgeManager.setFridge(FridgeUtils.loadFridge());
		fridgeManager.clearRedoList();
		fridgeManager.clearUndoList();

		this.addingMenuView = new AddingMenu(SwitchViewControler.fridgeManager);
		this.detailMenuView = new DetailMenu(fridgeManager);
		this.mainMenuView = new MainMenu(SwitchViewControler.fridgeManager);
		this.perishedMenuView = new PerishedView(fridgeManager);
		cardlayout = new CardLayout();
		SwitchViewControler.mainPanel = new JPanel(cardlayout);

	}

	public void buildCardLayout() {
		final JFrame frame = new JFrame("SmartFridge");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		/* sauvegarde du frigo à la fermeture */
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				FridgeUtils.saveFridge(fridgeManager.getFridge());
				frame.dispose();
			}
		});
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
					perishedMenuView.getLeftControl().refreshText("0");

				}
				changePanel(PERISHEDVIEW);
			}
		});
		
		this.addingMenuView.getRightProductMenuView().getReturnButton()
		.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainMenuView.getRightProductMenuController().refreshData();
				mainMenuView.getLeftButtonMenuController().refreshUndoRedo();
				changePanel(MAINVIEW);
			}
		});
		
		this.perishedMenuView.getLeftButtonMenuView().getMenuButton()
		.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainMenuView.getRightProductMenuController().refreshData();
				mainMenuView.getLeftButtonMenuController().refreshUndoRedo();
				changePanel(MAINVIEW);
			}
		});
		
		this.detailMenuView.getLeftDetailMenuView().getReturnButton()
		.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainMenuView.getRightProductMenuController().refreshData();
				mainMenuView.getLeftButtonMenuController().refreshUndoRedo();
				changePanel(MAINVIEW);
			}
		});
		
		this.addingMenuView.getRightProductMenuView().getValidationButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(addingMenuView.getRightAddMenuController().validationIsOk()){
					addingMenuView.getRightAddMenuController().addProduct();
					mainMenuView.getLeftButtonMenuController().refreshUndoRedo();
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
					detailMenuView.getRightProductMenuController().refreshSelected(mainMenuView.getRightProductMenuController().getIndexSelectedProduct());
					changePanel(DETAILVIEW);
				}
				
			}
		});
		
		this.detailMenuView.getLeftDetailMenuController().getView().getDeleteButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Really Want to Remove This Product?","WARNING",JOptionPane.OK_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){
					fridgeManager.executeAction(TypeActionEnum.REMOVE, detailMenuView.getRightProductMenuController().getSelectedProduct(), 0);
					detailMenuView.getRightProductMenuController().refreshData();
					mainMenuView.getLeftButtonMenuController().refreshUndoRedo();
					mainMenuView.getRightProductMenuController().refreshData();
					changePanel(MAINVIEW);
				}
				
				
			}
		});
		
		this.detailMenuView.getLeftDetailMenuController().getView().getDecreaseQuantityButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(detailMenuView.getRightProductMenuController().getSelectedProduct().getQuantity() == 1){
					fridgeManager.executeAction(TypeActionEnum.REMOVE, detailMenuView.getRightProductMenuController().getSelectedProduct(), 0);
					mainMenuView.getLeftButtonMenuController().refreshUndoRedo();
					mainMenuView.getRightProductMenuController().refreshData();
					changePanel(MAINVIEW);
				}
				
			}
		});

		this.perishedMenuView.getRightControl().getView().getProductList().addMouseListener(new MouseListener() {
			
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

				detailMenuView.getLeftDetailMenuController().refreshData(perishedMenuView.getRightControl().getSelectedProduct());
				detailMenuView.getRightProductMenuController().refreshDataPerished(Integer.parseInt(perishedMenuView.getLeftControl().getView().getPerishedLabel().getText()));
				detailMenuView.getRightProductMenuController().refreshSelected(perishedMenuView.getRightControl().getIndexSelectedProduct());
				changePanel(DETAILVIEW);


								
			}
		});
			
	}



	
	

}
