package smartfridge.view.sides;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class LeftPerishedMenuView extends LeftSide {

	private static final long serialVersionUID = 1L;

	private JLabel perishedInLabel;
	private JLabel perishedLabel;
	private JLabel perished;
	private JButton returnButton;

	public JButton getMenuButton() {
		return returnButton;
	}

	public LeftPerishedMenuView() {
		super();

		perishedInLabel = new JLabel("PRODUCT PERISHED IN");
		perishedLabel = new JLabel();

		perished = new JLabel("days");

		returnButton = new JButton(new ImageIcon("resources/returnButton.png"));
		returnButton.setBorder(BorderFactory.createEmptyBorder());
		returnButton.setContentAreaFilled(false);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(perishedInLabel);
		this.add(perishedLabel);
		this.add(perished);
		this.add(returnButton);

	}

	public JLabel getPerishedLabel() {
		return perishedLabel;
	}

	public JButton getReturnButton() {
		return returnButton;
	}

}
