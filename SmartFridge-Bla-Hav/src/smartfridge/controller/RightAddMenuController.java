package smartfridge.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import smartfridge.enu.TypeActionEnum;
import smartfridge.fridge.FridgeManager;
import smartfridge.product.ProductPerishable;
import smartfridge.product.ProductUnPerishable;
import smartfridge.view.sides.RightAddMenuView;

public class RightAddMenuController extends AddingMenuController {

	private FridgeManager fridge;
	private RightAddMenuView view;

	public RightAddMenuController(FridgeManager f) {

		this.setFridge(f);
		this.setView(new RightAddMenuView());
		this.view.getValidationButton().addActionListener(validationListener);
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

	private ActionListener validationListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String string = "";

			if (!validationIsOk()) {

				if (view.getNameTextField().getText().isEmpty()) {
					string += "Write a name for your add \n";
				}
				if (!verifQuantity()) {
					string += "Write a number in for quantity \n";
				}
				if (!verifType()) {
					string += "Choose a type at the left of the window";
				}

				JOptionPane.showMessageDialog(view, string, "Wrong Input",
						JOptionPane.WARNING_MESSAGE);

			}

		}
	};

	public void addProduct() {
		if (view.getDateSelection().getDate() == null) {
			fridge.executeAction(
					TypeActionEnum.ADD,
					new ProductUnPerishable(AddingMenuController.TYPE, view
							.getNameTextField().getText(), Integer
							.parseInt(view.getQuantityTextField().getText())),
					Integer.parseInt(view.getQuantityTextField().getText()));

		} else {
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(view.getDateSelection().getDate());
			calendar.add(Calendar.MONTH, 1);
			fridge.executeAction(
					TypeActionEnum.ADD,
					new ProductPerishable(AddingMenuController.TYPE, view
							.getNameTextField().getText(), Integer
							.parseInt(view.getQuantityTextField().getText()),
							calendar), Integer.parseInt(view
							.getQuantityTextField().getText()));

		}

	}

	private boolean verifType() {
		if (AddingMenuController.TYPE == null) {
			return false;
		}
		return true;
	}

	private boolean verifQuantity() {

		if (view.getQuantityTextField().getText().matches("\\d+")) {
			return true;

		} else
			return false;

	}

	public boolean validationIsOk() {
		if (view.getNameTextField().getText().isEmpty()) {
			return false;
		}
		if (!verifQuantity()) {
			return false;
		}
		if (AddingMenuController.TYPE == null) {
			return false;
		}
		return true;

	}

	public FridgeManager getFridge() {
		return fridge;
	}

	public void setFridge(FridgeManager fridge) {
		this.fridge = fridge;
	}

	public RightAddMenuView getView() {
		return this.view;
	}

	public void setView(RightAddMenuView rightAddMenuView) {
		this.view = rightAddMenuView;
	}
}
