package smartfridge.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;

import smartfridge.fridge.FridgeManager;
import smartfridge.view.sides.LeftPerishedMenuView;

public class LeftPerishedMenuController {

	private LeftPerishedMenuView view;

	public LeftPerishedMenuController(FridgeManager fridge) {
		this.view = new LeftPerishedMenuView();
		this.view.getReturnButton().addMouseListener(returnbuttonListener);
	}

	private MouseListener returnbuttonListener = new MouseListener() {

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
					"resources/returnButton.png"));
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if (((AbstractButton) e.getSource()).isEnabled()) {
				((AbstractButton) e.getSource()).setIcon(new ImageIcon(
						"resources/returnButtonFocus.png"));
			}

		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
	};

	public void refreshText(String t) {
		this.view.getPerishedLabel().setText(t);
	}

	public boolean verifText() {

		if (view.getPerishedLabel().getText().matches("\\d+")) {
			return true;
		} else
			return false;

	}

	public LeftPerishedMenuView getView() {
		return view;
	}

	public void setView(LeftPerishedMenuView view) {
		this.view = view;
	}

}
