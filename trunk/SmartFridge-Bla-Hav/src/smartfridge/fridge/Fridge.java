package smartfridge.fridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import smartfridge.actions.Actions;
import smartfridge.actions.CurrentDate;
import smartfridge.product.ProductAbstract;
import smartfridge.product.ProductPerishable;

public class Fridge {

	private List<ProductAbstract> fridgeContent = new ArrayList<ProductAbstract>();
	private ArrayList<Actions> unDo;
	private ArrayList<Actions> reDo;

	Comparator<ProductAbstract> comparatorAddingDate = new Comparator<ProductAbstract>() {

		@Override
		public int compare(ProductAbstract p1, ProductAbstract p2) {
			return p1.getDateAjout().compareTo(p2.getDateAjout());

		}
	};

	Comparator<ProductAbstract> comparatorPerishmentDate = new Comparator<ProductAbstract>() {

		@Override
		public int compare(ProductAbstract p1, ProductAbstract p2) {
			/* NE PAS prendre en compte les produits non p�rissables */
			return ((ProductPerishable) p1).getDatePerishment().compareTo(
					((ProductPerishable) p2).getDatePerishment());

		}
	};

	public List<ProductAbstract> getFridgeContent() {
		return fridgeContent;
	}

	/**
	 * LOADING FROM DB
	 * 
	 * @param fridgeContent
	 */
	public Fridge(ArrayList<ProductAbstract> fridgeContent) {
		super();
		this.fridgeContent = fridgeContent;
	}

	public Fridge() {
		// TODO Auto-generated constructor stub
	}

	public void addProduct(ProductAbstract p) {
		int idProd = this.fridgeContent.size();
		p.setProductId(idProd + 1);
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

		Collections.sort(this.fridgeContent, comparatorAddingDate);
	}

	public void sortProductByPerishmentDate() {
		Collections.sort(this.fridgeContent, comparatorPerishmentDate);

	}

	public void sortProductByType() {

	}

	public void sortProductByQuantity(boolean increase) {

	}

	@Override
	public String toString() {
		String res = "";

		for (ProductAbstract p : this.fridgeContent) {
			res += p.toString() + "\n";
		}

		return res;
	}

}
