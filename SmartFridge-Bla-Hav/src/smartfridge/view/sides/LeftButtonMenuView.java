package smartfridge.view.sides;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LeftButtonMenuView extends LeftSide {

	private static final long serialVersionUID = 1L;

	private JPanel panelUndoRedo;
	private JButton undoButton;
	private JButton redoButton;

	private JButton addingButton;
	private JButton removeButton;
	
	private JPanel panelSortBy;
	private JLabel sortByLabel;
	private JComboBox<String> sortBy;
	

	private JPanel panelCheck;
	private JButton checkButton;
	private JTextField checkIn;




	public LeftButtonMenuView() {
		super();
		
		
		panelUndoRedo = new JPanel();
		undoButton = new JButton(new ImageIcon("resources/UndoButton.png"));
		undoButton.setBorder(BorderFactory.createEmptyBorder());
		undoButton.setContentAreaFilled(false);
		redoButton = new JButton(new ImageIcon("resources/RedoButton.png"));
		redoButton.setBorder(BorderFactory.createEmptyBorder());
		redoButton.setContentAreaFilled(false);
		addingButton = new JButton(new ImageIcon("resources/buttonADDSmall.png"));
		addingButton.setBorder(BorderFactory.createEmptyBorder());
		addingButton.setContentAreaFilled(false);
		addingButton.setAlignmentX((float) 0.5);
		removeButton = new JButton(new ImageIcon("resources/removeAllSmall.png"));
		removeButton.setContentAreaFilled(false);
		removeButton.setBorder(BorderFactory.createEmptyBorder());
		removeButton.setAlignmentX((float) 0.5);


		panelCheck = new JPanel();
		panelCheck.setAlignmentX((float) 0.5);
		checkButton = new JButton(new ImageIcon("resources/buttonCheck.png"));
		checkButton.setBorder(BorderFactory.createEmptyBorder());
		checkButton.setContentAreaFilled(false);
		checkButton.setAlignmentX((float) 0.5);
		checkIn = new JTextField();
		checkIn.setPreferredSize(new Dimension(50,25));


		panelUndoRedo.setLayout(new BoxLayout(panelUndoRedo, BoxLayout.X_AXIS));
		panelUndoRedo.add(undoButton);
		panelUndoRedo.add(Box.createRigidArea(new Dimension(70,0)));
		panelUndoRedo.add(redoButton);
		panelUndoRedo.setAlignmentX((float) 0.5);

		//panelCheck.setLayout(new BoxLayout(panelCheck, BoxLayout.X_AXIS));
		panelCheck.add(checkButton);
		panelCheck.add(checkIn);
		
		panelSortBy = new JPanel();
		panelSortBy.setAlignmentX((float) 0.5);
		
		sortByLabel = new JLabel("Sort by");
		String[] string = {"AddingDate","PerishmentDate","Type","Quantity"};
		sortBy = new JComboBox<>(string);
		sortBy.setSelectedIndex(0);

		panelSortBy.add(sortByLabel);
		panelSortBy.add(sortBy);

		

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(panelUndoRedo);
		this.add(Box.createRigidArea(new Dimension(0,10)));
		this.add(addingButton);
		this.add(Box.createRigidArea(new Dimension(0,10)));
		this.add(removeButton);
		this.add(Box.createRigidArea(new Dimension(0,10)));
		this.add(panelSortBy);
		this.add(Box.createRigidArea(new Dimension(0,10)));
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
