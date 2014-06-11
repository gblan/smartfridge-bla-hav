package smartfridge.view.sides;

import java.util.Locale;

import javax.swing.BoxLayout;
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
	/* Pense a configurer ajouter le jar que j'ai mis dans le dossier /SRC a ton build path*/
	private JDateChooser dateSelection;

	private JPanel validationPanel;
	private JButton validationButton;
	private JButton returnButton;
	
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
		quantityTextField = new JTextField();
		quantityPanel.add(quantityLabel);
		quantityPanel.add(quantityTextField);
		
		expirationDatePanel = new JPanel();
		expirationDatePanel.setLayout(new BoxLayout(expirationDatePanel, BoxLayout.X_AXIS));
		expirationDateLabel = new JLabel("EXPIRATION DATE : ");
		dateSelection = new JDateChooser();
		dateSelection.setLocale(Locale.UK);
		
		expirationDatePanel.add(expirationDateLabel);
		expirationDatePanel.add(dateSelection);
		
		validationPanel = new JPanel();
		validationPanel.setLayout(new BoxLayout(validationPanel, BoxLayout.X_AXIS));
		validationButton = new JButton("OK");
		returnButton = new JButton("MENU");
		validationPanel.add(validationButton);
		validationPanel.add(returnButton);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(instructionPanel);
		this.add(namePanel);
		this.add(quantityPanel);
		this.add(expirationDatePanel);
		this.add(validationPanel);

		
	}

}
