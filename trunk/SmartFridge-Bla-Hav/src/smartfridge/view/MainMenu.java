package smartfridge.view;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SpringLayout;

import smartfridge.controller.LeftButtonMenuController;
import smartfridge.controller.RightProductMenuController;
import smartfridge.fridge.FridgeManager;
import smartfridge.utils.SpringUtilities;
import smartfridge.view.sides.LeftButtonMenuView;
import smartfridge.view.sides.RightProductMenuView;

public class MainMenu extends JPanel {

	private static final long serialVersionUID = 1L;
	private LeftButtonMenuController left;
	private RightProductMenuController right;
	
	protected FridgeManager fridge;
	

	public RightProductMenuController getRightProductMenuController(){
		return this.right;
	}

	public LeftButtonMenuView getLeftButtonMenuView() {
		return this.left.getView();
	}

	public RightProductMenuView getRightProductMenuView() {
		return this.right.getView();
	}

	public MainMenu(FridgeManager fridge) {

		/* Ajout des 2 parties de la fenêtre */

		
		this.fridge = fridge;
		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		
		
		left = new LeftButtonMenuController(fridge);
		//left = new LeftButtonMenuView();
		left.getView().setLayout(new SpringLayout());
		SpringUtilities.makeCompactGrid(this.left.getView(), 4, 1, 3, 3, 3, 3);

		mainPanel.add(this.left.getView());

		mainPanel.add(Box.createRigidArea(new Dimension(30, 0)));
		JSeparator separator = new JSeparator(JSeparator.VERTICAL);
		mainPanel.add(separator);
		mainPanel.add(Box.createRigidArea(new Dimension(30, 0)));

		right = new RightProductMenuController(fridge);
		mainPanel.add(right.getView());

		this.add(mainPanel);

		setVisible(true);
	}


}
