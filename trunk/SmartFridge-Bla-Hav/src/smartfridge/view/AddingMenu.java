package smartfridge.view;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SpringLayout;

import smartfridge.utils.SpringUtilities;
import smartfridge.view.sides.LeftAddMenuView;
import smartfridge.view.sides.LeftButtonMenuView;
import smartfridge.view.sides.RightAddMenuView;
import smartfridge.view.sides.RightProductMenuView;

public class AddingMenu extends JPanel{

	private static final long serialVersionUID = 1L;
	private LeftAddMenuView left;
	private RightAddMenuView right;

	public LeftAddMenuView getLeftButtonMenuView() {
		return left;
	}

	public RightAddMenuView getRightProductMenuView() {
		return right;
	}
	
	public AddingMenu(){

		/* Ajout des 2 parties de la fenêtre */

		JPanel mainPanel = new JPanel();
//		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

		left = new LeftAddMenuView();
//		left.setLayout(new SpringLayout());
//		SpringUtilities.makeCompactGrid(left, 8, 1, 3, 3, 3, 3);

		mainPanel.add(left);
		
		mainPanel.add(Box.createRigidArea(new Dimension(30	, 0)));
		JSeparator separator = new JSeparator(JSeparator.VERTICAL);		
		mainPanel.add(separator);
		mainPanel.add(Box.createRigidArea(new Dimension(30, 0)));


		right = new RightAddMenuView();
		
		right.setLayout(new SpringLayout());
		SpringUtilities.makeCompactGrid(right, 5, 1, 3, 3, 3, 3);
		mainPanel.add(right);

		this.add(mainPanel);

		setVisible(true);
	}
}
