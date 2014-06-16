package smartfridge.view;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import smartfridge.controller.LeftDetailMenuController;
import smartfridge.controller.RightProductMenuController;
import smartfridge.fridge.FridgeManager;
import smartfridge.view.sides.LeftDetailMenuView;
import smartfridge.view.sides.RightProductMenuView;

public class DetailMenu extends JPanel{

	private static final long serialVersionUID = 1L;
	private LeftDetailMenuController leftcontrol;
	private RightProductMenuController rightcontrol;

	
	
	public RightProductMenuController getRightProductMenuController(){
		return rightcontrol;
	}
	public LeftDetailMenuController getLeftDetailMenuController(){
		return leftcontrol;
	}
	public LeftDetailMenuView getLeftDetailMenuView() {
		return leftcontrol.getView();
	}

	public RightProductMenuView getRightProductMenuView() {
		return rightcontrol.getView();
	}
	
	public DetailMenu(FridgeManager fridge){

		/* Ajout des 2 parties de la fenêtre */

		
		leftcontrol = new LeftDetailMenuController();
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

		//leftcontrol.getView().setLayout(new SpringLayout());
		//SpringUtilities.makeCompactGrid(leftcontrol.getView(), 5, 1, 2, 2, 2, 2);
		
		mainPanel.add(leftcontrol.getView());

		mainPanel.add(Box.createRigidArea(new Dimension(30	, 0)));
		JSeparator separator = new JSeparator(JSeparator.VERTICAL);		
		mainPanel.add(separator);
		mainPanel.add(Box.createRigidArea(new Dimension(30, 0)));

		rightcontrol = new RightProductMenuController(fridge);
		mainPanel.add(rightcontrol.getView());

		this.add(mainPanel);

		setVisible(true);
	}
}
