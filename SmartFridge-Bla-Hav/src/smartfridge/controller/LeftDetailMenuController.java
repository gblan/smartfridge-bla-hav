package smartfridge.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;

import smartfridge.fridge.FridgeManager;
import smartfridge.product.ProductAbstract;
import smartfridge.product.ProductPerishable;
import smartfridge.view.sides.LeftDetailMenuView;

public class LeftDetailMenuController {

	private LeftDetailMenuView view;
	private FridgeManager fridge;

	public LeftDetailMenuController(FridgeManager fridge) {
		this.view = new LeftDetailMenuView();
		this.setFridge(fridge);
		this.view.getReturnButton().addMouseListener(returnbuttonListener);
		this.view.getDeleteButton().addMouseListener(deleteButtonListener);
	}

	private MouseListener deleteButtonListener = new MouseListener() {

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
					"resources/deleteProduct.png"));
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if (((AbstractButton) e.getSource()).isEnabled()) {
				((AbstractButton) e.getSource()).setIcon(new ImageIcon(
						"resources/deleteProductFocus.png"));
			}

		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
	};
	
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

	public void refreshData(ProductAbstract product) {

		ImageIcon i = new ImageIcon("resources/"
				+ product.getTypeProduct().toString().toLowerCase() + ".jpg");
		this.view.getImage().setIcon(i);
		this.view.getNomLabel().setText(product.getProductName());
		if (product instanceof ProductPerishable) {
			this.view.getExpirationDateLabel()
					.setText(
							((ProductPerishable) product).getDatePerishment()
									.get(Calendar.DATE)
									+ "/"
									+ (((ProductPerishable) product)
											.getDatePerishment().get(
													Calendar.MONTH) + 1)
									+ "/"
									+ ((ProductPerishable) product)
											.getDatePerishment().get(
													Calendar.YEAR));

		} else {
			this.view.getExpirationDateLabel().setText("Unperishable");
		}
		this.view.getActualQUantity().setText(
				String.valueOf(product.getQuantity()));

	}

	public LeftDetailMenuView getView() {
		return view;
	}

	public void setView(LeftDetailMenuView view) {
		this.view = view;
	}

	public FridgeManager getFridge() {
		return fridge;
	}

	public void setFridge(FridgeManager fridge) {
		this.fridge = fridge;
	}
}
