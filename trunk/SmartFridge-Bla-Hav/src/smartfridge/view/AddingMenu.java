package smartfridge.view;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import smartfridge.view.sides.LeftAddMenuView;
import smartfridge.view.sides.RightAddMenuView;

public class AddingMenu extends JFrame{

	private static final long serialVersionUID = 1L;

	public AddingMenu(){
		super("Smart Fridge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Ajout des 2 parties de la fen�tre */

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

		LeftAddMenuView left = new LeftAddMenuView();
		mainPanel.add(left);

		JSeparator separator = new JSeparator();
		mainPanel.add(separator);

		RightAddMenuView right = new RightAddMenuView();
		mainPanel.add(right);

		this.add(mainPanel);

		pack();

		setLocationRelativeTo(null);
		setVisible(true);
	}
}
