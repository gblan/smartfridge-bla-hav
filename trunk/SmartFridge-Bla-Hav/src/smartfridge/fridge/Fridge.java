package smartfridge.fridge;

import java.util.ArrayList;
import java.util.Collections;

import smartfridge.actions.Actions;
import smartfridge.actions.CurrentDate;
import smartfridge.product.ProductAbstract;
import smartfridge.product.ProductPerishable;

public class Fridge {

	private ArrayList<ProductAbstract> fridgeContent;
	private ArrayList<Actions> unDo;
	private ArrayList<Actions> reDo;

	/**
	 * LOADING FROM DB
	 * 
	 * @param fridgeContent
	 */
	public Fridge(ArrayList<ProductAbstract> fridgeContent) {
		super();
		this.fridgeContent = fridgeContent;
	}

	public void addProduct(ProductAbstract p) {
		this.fridgeContent.add(p);
	}

	public boolean deleteProduct(ProductAbstract p) {
		if (this.fridgeContent.remove(p)) {
			return true;
		} else {
			return false;
		}
	}

	public void deletePerishedProduct() {
		for (ProductAbstract p : this.fridgeContent) {
			if (p instanceof ProductPerishable) {
				if (((ProductPerishable) p).getDatePerishment().compareTo(
						CurrentDate.getCurrentDate()) == -1) {
					this.fridgeContent.remove(p);
				}
			}
		}
	}

	public void showListPerishedProductIn(int n) {
		
	}

	public void sortProductByAddingDate() {
		Collections.sort(this.fridgeContent);
	}

	public void sortProductByPerishmentDate() {
		
	}

	public void sortProductByType() {
		
	}

	public void sortProductByQuantity(boolean increase) {
		
	}

}
