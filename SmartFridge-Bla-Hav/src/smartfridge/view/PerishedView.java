package smartfridge.view;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SpringLayout;

import smartfridge.utils.SpringUtilities;
import smartfridge.view.sides.LeftButtonMenuView;
import smartfridge.view.sides.LeftPerishedMenuView;
import smartfridge.view.sides.RightProductMenuView;

public class PerishedView extends JPanel {

	private static final long serialVersionUID = 1L;
	private LeftPerishedMenuView left;
	private RightProductMenuView right;

	public LeftPerishedMenuView getLeftButtonMenuView() {
		return left;
	}

	public RightProductMenuView getRightProductMenuView() {
		return right;
	}
	
	public PerishedView() {

		/* Ajout des 2 parties de la fenêtre */

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

		left = new LeftPerishedMenuView();
		left.setLayout(new SpringLayout());
		SpringUtilities.makeCompactGrid(left, 4, 1, 3, 3, 3, 3);
		
		mainPanel.add(left);

		mainPanel.add(Box.createRigidArea(new Dimension(30	, 0)));
		JSeparator separator = new JSeparator(JSeparator.VERTICAL);		
		mainPanel.add(separator);
		mainPanel.add(Box.createRigidArea(new Dimension(30, 0)));

		right = new RightProductMenuView();
		mainPanel.add(right);

		this.add(mainPanel);

		setVisible(true);
	}
}
