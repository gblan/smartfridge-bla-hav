package smartfridge.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import smartfridge.product.ProductAbstract;
import smartfridge.product.ProductPerishable;
import smartfridge.view.sides.LeftDetailMenuView;

public class LeftDetailMenuController {

	private LeftDetailMenuView view;

	public LeftDetailMenuController() {
		this.view = new LeftDetailMenuView();

	}

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
	
	private void addQuantityControler(){
		this.view.getDecreaseQuantityButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		this.view.getIncreaseQuantityButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	public LeftDetailMenuView getView() {
		return view;
	}

	public void setView(LeftDetailMenuView view) {
		this.view = view;
	}
}
