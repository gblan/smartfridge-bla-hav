package smartfridge.controller;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		this.detailMenuView = new DetailMenu();
		this.mainMenuView = new MainMenu(SwitchViewControler.fridge);
		this.perishedMenuView = new PerishedView();
		cardlayout = new CardLayout();
		SwitchViewControler.mainPanel = new JPanel(cardlayout);

	}

	public void buildCardLayout() {
		final JFrame frame = new JFrame();
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
				mainMenuView.getRightProductMenuController().refreshData();
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
		
		this.detailMenuView.getLeftButtonMenuView().getReturnButton()
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
		
			
	}



	
	

}
