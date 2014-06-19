package smartfridge.view.sides;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class LeftDetailMenuView extends LeftSide {

	private static final long serialVersionUID = 1L;
	
	private JPanel identityPanel;
	
	private JPanel iconePanel;
	private JLabel image;

	private JLabel nomLabel;
	private JLabel expirationDateLabel;

	private JPanel panelQuantity;
	private JButton decreaseQuantityButton;
	private JTextField actualQUantity;
	private JButton increaseQuantityButton;

	private JPanel deleteReturnPanel;
	private JButton deleteButton;
	private JButton returnButton;
	
	public JButton getReturnButton() {
		return returnButton;
	}

	public LeftDetailMenuView() {
		super();

		identityPanel = new JPanel();
		
		iconePanel = new JPanel();
		iconePanel.setPreferredSize(new Dimension(75,75));
		image = new JLabel();
		iconePanel.add(image);
		nomLabel = new JLabel("ProductName");
		nomLabel.setAlignmentX((float) 0.5);
		expirationDateLabel = new JLabel("EXPIRATION DATE");
		expirationDateLabel.setAlignmentX((float) 0.5);

		panelQuantity = new JPanel();
		panelQuantity.setLayout(new FlowLayout());

		decreaseQuantityButton = new JButton("-");
		actualQUantity = new JTextField();
		actualQUantity.setPreferredSize(new Dimension(50,25));

		increaseQuantityButton = new JButton("+");
		panelQuantity.add(decreaseQuantityButton);
		panelQuantity.add(actualQUantity);
		panelQuantity.add(increaseQuantityButton);

		deleteReturnPanel = new JPanel();
		deleteButton = new JButton("DELETE");
		returnButton = new JButton("RETURN");
		deleteReturnPanel.add(deleteButton);
		deleteReturnPanel.add(returnButton);
		
		identityPanel.add(iconePanel);
		identityPanel.add(nomLabel);
		identityPanel.add(expirationDateLabel);
		identityPanel.setLayout(new BoxLayout(identityPanel, BoxLayout.Y_AXIS));
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//this.add(iconePanel);
		//this.add(nomLabel);
		//this.add(expirationDateLabel);
		this.add(identityPanel);
		this.add(Box.createRigidArea(new Dimension(0,100)));

		this.add(panelQuantity);
		this.add(deleteReturnPanel);
	}

	public JButton getDecreaseQuantityButton() {
		return decreaseQuantityButton;
	}

	public void setDecreaseQuantityButton(JButton decreaseQuantityButton) {
		this.decreaseQuantityButton = decreaseQuantityButton;
	}

	public JTextField getActualQUantity() {
		return actualQUantity;
	}

	public void setActualQUantity(JTextField actualQUantity) {
		this.actualQUantity = actualQUantity;
	}

	public JButton getIncreaseQuantityButton() {
		return increaseQuantityButton;
	}

	public void setIncreaseQuantityButton(JButton increaseQuantityButton) {
		this.increaseQuantityButton = increaseQuantityButton;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(JButton deleteButton) {
		this.deleteButton = deleteButton;
	}

	public void setReturnButton(JButton returnButton) {
		this.returnButton = returnButton;
	}

	public JPanel getIconePanel() {
		return iconePanel;
	}

	public void setIconePanel(JPanel iconePanel) {
		this.iconePanel = iconePanel;
	}

	public JLabel getImage() {
		return image;
	}

	public void setImage(JLabel image) {
		this.image = image;
	}

	public JLabel getNomLabel() {
		return nomLabel;
	}

	public void setNomLabel(JLabel nomLabel) {
		this.nomLabel = nomLabel;
	}

	public JLabel getExpirationDateLabel() {
		return expirationDateLabel;
	}

	public void setExpirationDateLabel(JLabel expirationDateLabel) {
		this.expirationDateLabel = expirationDateLabel;
	}

	public JPanel getPanelQuantity() {
		return panelQuantity;
	}

	public void setPanelQuantity(JPanel panelQuantity) {
		this.panelQuantity = panelQuantity;
	}

}
