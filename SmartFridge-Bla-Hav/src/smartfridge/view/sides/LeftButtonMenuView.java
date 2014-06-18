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
	private JLabel checkTextBegin;
	private JTextField checkIn;
	private JLabel checkTextEnd;




	public LeftButtonMenuView() {
		super();
		
		
		panelUndoRedo = new JPanel();
		undoButton = new JButton(new ImageIcon("resources/UndoButton.png"));
		undoButton.setBorder(BorderFactory.createEmptyBorder());
		redoButton = new JButton(new ImageIcon("resources/RedoButton.png"));
		redoButton.setBorder(BorderFactory.createEmptyBorder());
		addingButton = new JButton(new ImageIcon("resources/buttonADDSmall.png"));
		addingButton.setBorder(BorderFactory.createEmptyBorder());
		removeButton = new JButton(new ImageIcon("resources/removeAllSmall.png"));
		removeButton.setBorder(BorderFactory.createEmptyBorder());

		panelCheck = new JPanel();
		panelCheck.setPreferredSize(new Dimension(85,50));
		checkButton = new JButton("Check");
		checkButton.setPreferredSize(new Dimension(75,25));
		checkTextBegin = new JLabel("Perished Product in");
		checkIn = new JTextField();
		checkIn.setPreferredSize(new Dimension(50,25));
		checkIn.setSize(new Dimension(10,50));
		checkTextEnd = new JLabel("day(s)");


		panelUndoRedo.setLayout(new BoxLayout(panelUndoRedo, BoxLayout.X_AXIS));
		panelUndoRedo.add(undoButton);
		panelUndoRedo.add(Box.createRigidArea(new Dimension(70,0)));
		panelUndoRedo.add(redoButton);

		//panelCheck.setLayout(new BoxLayout(panelCheck, BoxLayout.X_AXIS));
		panelCheck.add(checkButton);
		panelCheck.add(checkTextBegin);
		panelCheck.add(checkIn);
		panelCheck.add(checkTextEnd);
		
		panelSortBy = new JPanel();
		
		sortByLabel = new JLabel("Sort by");
		String[] string = {"AddingDate","PerishmentDate","Type","Quantity"};
		sortBy = new JComboBox<>(string);
		sortBy.setSelectedIndex(0);

		panelSortBy.add(sortByLabel);
		panelSortBy.add(sortBy);

		

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(panelUndoRedo);
		this.add(Box.createRigidArea(new Dimension(0,20)));
		this.add(addingButton);
		this.add(Box.createRigidArea(new Dimension(0,20)));
		this.add(removeButton);
		this.add(Box.createRigidArea(new Dimension(0,20)));
		this.add(panelSortBy);
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
