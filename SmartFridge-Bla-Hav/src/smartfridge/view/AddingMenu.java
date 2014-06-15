package smartfridge.view;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SpringLayout;

import smartfridge.controller.LeftAddMenuController;
import smartfridge.controller.RightAddMenuController;
import smartfridge.enu.TypeProductEnum;
import smartfridge.fridge.FridgeManager;
import smartfridge.utils.SpringUtilities;
import smartfridge.view.sides.LeftAddMenuView;
import smartfridge.view.sides.RightAddMenuView;

public class AddingMenu extends JPanel{

	private static final long serialVersionUID = 1L;
	private LeftAddMenuController left;
	private RightAddMenuController right;
	
	private TypeProductEnum type;
	
	protected FridgeManager fridge;

	public LeftAddMenuView getLeftButtonMenuView() {
		return left.getView();
	}

	public RightAddMenuView getRightProductMenuView() {
		return right.getView();
	}
	
	public RightAddMenuController getRightAddMenuController(){
		return this.right;
	}
	
	public AddingMenu(FridgeManager fridge){

		/* Ajout des 2 parties de la fenêtre */

		this.fridge = fridge;
		JPanel mainPanel = new JPanel();
//		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

		left = new LeftAddMenuController(fridge);
//		left.setLayout(new SpringLayout());
//		SpringUtilities.makeCompactGrid(left, 8, 1, 3, 3, 3, 3);

		mainPanel.add(left.getView());
		
		mainPanel.add(Box.createRigidArea(new Dimension(30	, 0)));
		JSeparator separator = new JSeparator(JSeparator.VERTICAL);		
		mainPanel.add(separator);
		mainPanel.add(Box.createRigidArea(new Dimension(30, 0)));


		right = new RightAddMenuController(fridge);
		
		right.getView().setLayout(new SpringLayout());
		SpringUtilities.makeCompactGrid(right.getView(), 5, 1, 3, 3, 3, 3);
		mainPanel.add(right.getView());

		this.add(mainPanel);

		setVisible(true);
	}

	public TypeProductEnum getType() {
		return type;
	}

	public void setType(TypeProductEnum type) {
		this.type = type;
	}
}
