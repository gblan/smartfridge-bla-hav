package smartfridge.view.sides;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import smartfridge.controller.LeftDetailMenuController;

public class LeftDetailMenuView extends LeftSide {

	private static final long serialVersionUID = 1L;
	
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
		deleteButton = new JButton("DELETE");
		returnButton = new JButton("RETURN");
		deleteReturnPanel.add(deleteButton);
		deleteReturnPanel.add(returnButton);

		LeftDetailMenuController controler = new LeftDetailMenuController();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(iconePanel);
		this.add(nomLabel);
		this.add(expirationDateLabel);
		this.add(panelQuantity);
		this.add(deleteReturnPanel);
	}

}
