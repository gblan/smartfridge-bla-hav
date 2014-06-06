package smartfridge.view;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import smartfridge.view.sides.LeftDetailMenuView;
import smartfridge.view.sides.RightProductMenuView;

public class DetailMenu extends JFrame{

	private static final long serialVersionUID = 1L;

	public DetailMenu(){
		super("Smart Fridge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Ajout des 2 parties de la fenêtre */

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

		LeftDetailMenuView left = new LeftDetailMenuView();
		mainPanel.add(left);

		JSeparator separator = new JSeparator();
		mainPanel.add(separator);

		RightProductMenuView right = new RightProductMenuView();
		mainPanel.add(right);

		this.add(mainPanel);

		pack();

		setLocationRelativeTo(null);
		setVisible(true);
	}
}
