package smartfridge.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;

import smartfridge.fridge.FridgeManager;
import smartfridge.view.sides.LeftButtonMenuView;

public class LeftButtonMenuController {

	private FridgeManager fridge;
	private LeftButtonMenuView view;

	public LeftButtonMenuController(FridgeManager fridge) {
		this.setView(new LeftButtonMenuView());
		this.getView().getAddingButton().addMouseListener(addingbuttonListener);
		this.getView().getRemoveButton().addMouseListener(removebuttonListener);
		this.getView().getCheckButton().addMouseListener(checkbuttonListener);
		this.getView().getUndoButton().addMouseListener(undobuttonListener);
		this.getView().getRedoButton().addMouseListener(redobuttonListener);

		this.fridge = fridge;
	}

	private MouseListener redobuttonListener = new MouseListener() {

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			((AbstractButton) e.getSource()).setIcon(new ImageIcon(
					"resources/RedoButton.png"));
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if (((AbstractButton) e.getSource()).isEnabled()) {
				((AbstractButton) e.getSource()).setIcon(new ImageIcon(
						"resources/RedoButtonFocus.png"));
			}

		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
	};

	private MouseListener undobuttonListener = new MouseListener() {

		@Override
		public void mouseReleased(MouseEvent e) {
			if (!((AbstractButton) e.getSource()).isEnabled()) {
				((AbstractButton) e.getSource()).setIcon(new ImageIcon(
						"resources/UndoButton.png"));
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {
			((AbstractButton) e.getSource()).setIcon(new ImageIcon(
					"resources/UndoButton.png"));
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if (((AbstractButton) e.getSource()).isEnabled()) {
				((AbstractButton) e.getSource()).setIcon(new ImageIcon(
						"resources/UndoButtonFocus.png"));
			}

		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
	};

	private MouseListener checkbuttonListener = new MouseListener() {

		@Override
		public void mouseReleased(MouseEvent e) {
			if (!((AbstractButton) e.getSource()).isEnabled()) {
				((AbstractButton) e.getSource()).setIcon(new ImageIcon(
						"resources/UndoButton.png"));
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			((AbstractButton) e.getSource()).setIcon(new ImageIcon(
					"resources/buttonCheck.png"));

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			((AbstractButton) e.getSource()).setIcon(new ImageIcon(
					"resources/buttonCheckFocus.png"));

		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
	};
	private MouseListener removebuttonListener = new MouseListener() {

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			((AbstractButton) e.getSource()).setIcon(new ImageIcon(
					"resources/removeAllSmall.png"));

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			((AbstractButton) e.getSource()).setIcon(new ImageIcon(
					"resources/removeAllSmallFocus.png"));

		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
	};

	private MouseListener addingbuttonListener = new MouseListener() {

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			((AbstractButton) e.getSource()).setIcon(new ImageIcon(
					"resources/buttonAddSmall.png"));

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			((AbstractButton) e.getSource()).setIcon(new ImageIcon(
					"resources/buttonAddSmallFocus.png"));

		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
	};

	public void refreshUndoRedo() {
		if (!fridge.undoIsEmpty()) {
			this.view.getUndoButton().setEnabled(true);
		} else {
			this.view.getUndoButton().setEnabled(false);

		}
		if (!fridge.redoIsEmpty()) {
			this.view.getRedoButton().setEnabled(true);
		} else {
			this.view.getRedoButton().setEnabled(false);

		}
	}

	public LeftButtonMenuView getView() {
		return view;
	}

	public void setView(LeftButtonMenuView view) {
		this.view = view;
	}

}
