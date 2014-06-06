package smartfridge.view.sides;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LeftPerishedMenuView extends LeftSide {

	private JLabel perishedInLabel;
	private JTextField perishedLabel;
	private JLabel perished;
	private JButton menuButton;
	
	public LeftPerishedMenuView() {
		super();

		perishedInLabel = new JLabel("PRODUCT PERISHED IN");
		perishedLabel = new JTextField("");

		perished = new JLabel("days");
		
		menuButton = new JButton("RETURN");
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(perishedInLabel);
		this.add(perishedLabel);
		this.add(perished);
		this.add(menuButton);

	}
}
