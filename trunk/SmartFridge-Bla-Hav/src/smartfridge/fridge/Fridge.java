package smartfridge.fridge;

import java.util.ArrayList;

import smartfridge.actions.Actions;
import smartfridge.actions.Date;
import smartfridge.product.ProductBean;
import smartfridge.product.ProductPerishable;

public class Fridge {

	private ArrayList<ProductBean> fridgeContent;
	private ArrayList<Actions> unDo;
	private ArrayList<Actions> reDo;

	/**
	 * LOADING FROM DB
	 * 
	 * @param fridgeContent
	 */
	public Fridge(ArrayList<ProductBean> fridgeContent) {
		super();
		this.fridgeContent = fridgeContent;
	}

	public void addProduct(ProductBean p) {
		this.fridgeContent.add(p);
	}

	public boolean deleteProduct(ProductBean p) {
		if (this.fridgeContent.remove(p)) {
			return true;
		} else {
			return false;
		}
	}

	public void deletePerishedProduct() {
		for(ProductBean p : this.fridgeContent){
			if(p instanceof ProductPerishable){
				if (((ProductPerishable) p).getDatePerishment() < Date.date()){
					
				}
			}
		}
	}

	public void showListPerishedProductIn(int n) {

	}

	public void sortProductByDate() {

	}

	public void sortProductByPerishmentDate() {

	}

	public void sortProductByType() {

	}

	public void sortProductByQuantity(boolean increase) {

	}

}
