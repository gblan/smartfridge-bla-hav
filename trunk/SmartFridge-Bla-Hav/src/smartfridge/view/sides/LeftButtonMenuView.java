package smartfridge.view.sides;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import smartfridge.controller.LeftAddMenuController;
import smartfridge.controller.LeftButtonMenuController;
import smartfridge.fridge.FridgeManager;

public class LeftButtonMenuView extends LeftSide {

	private static final long serialVersionUID = 1L;

	private JPanel panelUndoRedo;
	private JButton undoButton;
	private JButton redoButton;

	private JButton addingButton;
	private JButton removeButton;

	private JPanel panelCheck;
	private JButton checkButton;
	private JTextField checkIn;




	public LeftButtonMenuView() {
		super();
		

		panelUndoRedo = new JPanel();
		undoButton = new JButton("UnDo");
		redoButton = new JButton("ReDo");

		addingButton = new JButton("Add");
		removeButton = new JButton("Remove");

		panelCheck = new JPanel();
		checkButton = new JButton("Check");
		checkIn = new JTextField();

		panelUndoRedo.setLayout(new BoxLayout(panelUndoRedo, BoxLayout.X_AXIS));
		panelUndoRedo.add(undoButton);
		panelUndoRedo.add(redoButton);

		panelCheck.setLayout(new BoxLayout(panelCheck, BoxLayout.X_AXIS));
		panelCheck.add(checkButton);
		panelCheck.add(checkIn);


		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(panelUndoRedo);
		this.add(addingButton);
		this.add(removeButton);
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
}
