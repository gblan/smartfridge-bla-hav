package smartfridge.view;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SpringLayout;

import smartfridge.utils.SpringUtilities;
import smartfridge.view.sides.LeftDetailMenuView;
import smartfridge.view.sides.RightProductMenuView;

public class DetailMenu extends JFrame{

	private static final long serialVersionUID = 1L;

	public DetailMenu(){
		super("Smart Fridge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Ajout des 2 parties de la fen�tre */

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

		LeftDetailMenuView left = new LeftDetailMenuView();
		left.setLayout(new SpringLayout());
		SpringUtilities.makeCompactGrid(left, 5, 1, 2, 2, 2, 2);
		
		mainPanel.add(left);

		mainPanel.add(Box.createRigidArea(new Dimension(30	, 0)));
		JSeparator separator = new JSeparator(JSeparator.VERTICAL);		
		mainPanel.add(separator);
		mainPanel.add(Box.createRigidArea(new Dimension(30, 0)));

		RightProductMenuView right = new RightProductMenuView();
		mainPanel.add(right);

		this.add(mainPanel);

		pack();

		setLocationRelativeTo(null);
		setVisible(true);
	}
}
