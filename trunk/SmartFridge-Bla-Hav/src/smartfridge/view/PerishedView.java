package smartfridge.view;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import smartfridge.view.sides.LeftPerishedMenuView;
import smartfridge.view.sides.RightProductMenuView;

public class PerishedView extends JFrame {

	public PerishedView() {
		super("Smart Fridge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Ajout des 2 parties de la fenêtre */

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

		LeftPerishedMenuView left = new LeftPerishedMenuView();
		mainPanel.add(left);

		JSeparator separator = new JSeparator();
		mainPanel.add(separator);

		RightProductMenuView right = new RightProductMenuView();
		mainPanel.add(right);

		this.add(mainPanel);

//		pack();

		setLocationRelativeTo(null);
		setVisible(true);
	}
}
