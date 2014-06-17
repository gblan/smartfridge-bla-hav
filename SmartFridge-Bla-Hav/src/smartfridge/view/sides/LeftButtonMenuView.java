package smartfridge.view.sides;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LeftButtonMenuView extends LeftSide {

	private static final long serialVersionUID = 1L;

	private JPanel panelUndoRedo;
	private JButton undoButton;
	private JButton redoButton;

	private JButton addingButton;
	private JButton removeButton;
	private JComboBox<String> sortBy;
	

	private JPanel panelCheck;
	private JButton checkButton;
	private JTextField checkIn;




	public LeftButtonMenuView() {
		super();
		
		
		panelUndoRedo = new JPanel();
		undoButton = new JButton("UnDo");
		redoButton = new JButton("ReDo");

		addingButton = new JButton(new ImageIcon("resources/buttonADD.png"));
		removeButton = new JButton("Remove");

		panelCheck = new JPanel();
		panelCheck.setPreferredSize(new Dimension(85,50));
		checkButton = new JButton("Check");
		checkButton.setPreferredSize(new Dimension(75,50));
		checkIn = new JTextField();
		checkIn.setPreferredSize(new Dimension(10,50));

		panelUndoRedo.setLayout(new BoxLayout(panelUndoRedo, BoxLayout.X_AXIS));
		panelUndoRedo.add(undoButton);
		panelUndoRedo.add(redoButton);

		panelCheck.setLayout(new BoxLayout(panelCheck, BoxLayout.X_AXIS));
		panelCheck.add(checkButton);
		panelCheck.add(checkIn);

		
		String[] string = {"AddingDate","PerishmentDate","Type","Quantity"};
		sortBy = new JComboBox<>(string);
		sortBy.setSelectedIndex(0);

		

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(panelUndoRedo);
		this.add(Box.createRigidArea(new Dimension(0,20)));
		this.add(addingButton);
		this.add(Box.createRigidArea(new Dimension(0,20)));
		this.add(removeButton);
		this.add(Box.createRigidArea(new Dimension(0,20)));
		this.add(sortBy);
		this.add(Box.createRigidArea(new Dimension(0,20)));
		this.add(panelCheck);
	}

	public JButton getUndoButton() {
		return undoButton;
	}

	public void setUndoButton(JButton undoButton) {
		this.undoButton = undoButton;
	}
	
	public JButton getAddingButton() {
		return addingButton;
	}
	
	public JButton getCheckButton() {
		return checkButton;
	}

	public JButton getRedoButton() {
		return redoButton;
	}

	public void setRedoButton(JButton redoButton) {
		this.redoButton = redoButton;
	}

	public JButton getRemoveButton() {
		return removeButton;
	}

	public void setRemoveButton(JButton removeButton) {
		this.removeButton = removeButton;
	}

	public JTextField getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(JTextField checkIn) {
		this.checkIn = checkIn;
	}

	public JComboBox<String> getSortBy() {
		return sortBy;
	}

	public void setSortBy(JComboBox<String> sortBy) {
		this.sortBy = sortBy;
	}
}
