package smartfridge.view.sides;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LeftDetailMenuView extends LeftSide {

	private JPanel iconePanel;

	private JLabel nomLabel;
	private JLabel expirationDateLabel;

	private JPanel panelQuantity;
	private JButton decreaseQuantityButton;
	private JTextField actualQUantity;
	private JButton increaseQuantityButton;

	private JPanel deleteReturnPanel;
	private JButton deleteButton;
	private JButton returnButton;

	public LeftDetailMenuView() {
		super();

		iconePanel = new JPanel();
		nomLabel = new JLabel("ProductName");
		expirationDateLabel = new JLabel("EXPIRATION DATE");

		panelQuantity = new JPanel();
		panelQuantity.setLayout(new BoxLayout(panelQuantity, BoxLayout.X_AXIS));

		decreaseQuantityButton = new JButton("-");
		actualQUantity = new JTextField();
		increaseQuantityButton = new JButton("+");
		panelQuantity.add(decreaseQuantityButton);
		panelQuantity.add(actualQUantity);
		panelQuantity.add(increaseQuantityButton);

		deleteReturnPanel = new JPanel();
		returnButton = new JButton("RETURN");
		deleteButton = new JButton("DELETE");
		deleteReturnPanel.add(returnButton);
		deleteReturnPanel.add(deleteButton);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(iconePanel);
		this.add(nomLabel);
		this.add(expirationDateLabel);
		this.add(panelQuantity);
		this.add(deleteReturnPanel);
	}

}
