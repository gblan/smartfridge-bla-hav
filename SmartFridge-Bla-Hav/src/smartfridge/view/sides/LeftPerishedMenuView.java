package smartfridge.view.sides;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;


public class LeftPerishedMenuView extends LeftSide {

	private static final long serialVersionUID = 1L;

	private JLabel perishedInLabel;
	private JLabel perishedLabel;
	private JLabel perished;
	private JButton menuButton;

	public JButton getMenuButton() {
		return menuButton;
	}

	public LeftPerishedMenuView() {
		super();

		perishedInLabel = new JLabel("PRODUCT PERISHED IN");
		perishedLabel = new JLabel();

		perished = new JLabel("days");

		menuButton = new JButton("RETURN");



		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(perishedInLabel);
		this.add(perishedLabel);
		this.add(perished);
		this.add(menuButton);

	}

	public JLabel getPerishedLabel() {
		return perishedLabel;
	}

	public void setPerishedLabel(JLabel perishedLabel) {
		this.perishedLabel = perishedLabel;
	}
}
