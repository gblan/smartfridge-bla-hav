package smartfridge.view.sides;

import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class RightAddMenuView extends RightSide {

	private static final long serialVersionUID = 1L;

	private JPanel instructionPanel;
	private JLabel instructionsLabel;

	private JPanel namePanel;
	private JLabel nameLabel;
	private JTextField nameTextField;

	private JPanel quantityPanel;
	private JLabel quantityLabel;
	private JTextField quantityTextField;

	private JPanel expirationDatePanel;
	private JLabel expirationDateLabel;
	/*
	 * Pense a configurer ajouter le jar que j'ai mis dans le dossier /SRC a ton
	 * build path
	 */
	private JDateChooser dateSelection;

	private JPanel validationPanel;
	private JButton validationButton;
	private JButton returnButton;

	public JButton getReturnButton() {
		return returnButton;
	}

	public RightAddMenuView() {
		super();

		instructionPanel = new JPanel();
		instructionsLabel = new JLabel("INSTRUCTIONS");
		instructionPanel.add(instructionsLabel);

		namePanel = new JPanel();
		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
		nameLabel = new JLabel("NAME : ");
		nameTextField = new JTextField();
		namePanel.add(nameLabel);
		namePanel.add(nameTextField);

		quantityPanel = new JPanel();
		quantityPanel.setLayout(new BoxLayout(quantityPanel, BoxLayout.X_AXIS));
		quantityLabel = new JLabel("QUANTITY : ");
		quantityTextField = new JTextField("1");
		quantityPanel.add(quantityLabel);
		quantityPanel.add(quantityTextField);

		expirationDatePanel = new JPanel();
		expirationDatePanel.setLayout(new BoxLayout(expirationDatePanel,
				BoxLayout.X_AXIS));
		expirationDateLabel = new JLabel("EXPIRATION DATE : ");
		dateSelection = new JDateChooser();
		dateSelection.setLocale(Locale.UK);

		expirationDatePanel.add(expirationDateLabel);
		expirationDatePanel.add(dateSelection);

		validationPanel = new JPanel();
		validationPanel.setLayout(new BoxLayout(validationPanel,
				BoxLayout.X_AXIS));
		validationButton = new JButton(new ImageIcon(
				"resources/AddToFridge.png"));
		validationButton.setBorder(BorderFactory.createEmptyBorder());
		validationButton.setContentAreaFilled(false);

		returnButton = new JButton(new ImageIcon("resources/returnButton.png"));
		returnButton.setBorder(BorderFactory.createEmptyBorder());
		returnButton.setContentAreaFilled(false);

		validationPanel.add(validationButton);
		validationPanel.add(returnButton);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(instructionPanel);
		this.add(namePanel);
		this.add(quantityPanel);
		this.add(expirationDatePanel);
		this.add(validationPanel);

	}

	public JTextField getQuantityTextField() {
		return quantityTextField;
	}

	public void setQuantityTextField(JTextField quantityTextField) {
		this.quantityTextField = quantityTextField;
	}

	public JButton getValidationButton() {
		return validationButton;
	}

	public void setValidationButton(JButton validationButton) {
		this.validationButton = validationButton;
	}

	public JTextField getNameTextField() {
		return nameTextField;
	}

	public void setNameTextField(JTextField nameTextField) {
		this.nameTextField = nameTextField;
	}

	public JDateChooser getDateSelection() {
		return dateSelection;
	}

	public void setDateSelection(JDateChooser dateSelection) {
		this.dateSelection = dateSelection;
	}

}
