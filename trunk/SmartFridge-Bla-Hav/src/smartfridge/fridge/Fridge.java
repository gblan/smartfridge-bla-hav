package smartfridge.fridge;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import smartfridge.actions.Actions;
import smartfridge.actions.CurrentDate;
import smartfridge.product.ProductAbstract;
import smartfridge.product.ProductPerishable;
import smartfridge.product.ProductUnPerishable;

public class Fridge implements Serializable{

	private static final long serialVersionUID = -5601074623725600420L;
	private List<ProductAbstract> fridgeContent = new ArrayList<ProductAbstract>();
	private ArrayList<Actions> unDo;
	private ArrayList<Actions> reDo;

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
		this.fridgeContent.add(p);
	}

	public void deleteProduct(int n) {
		this.fridgeContent.remove(n);
	}

	public void deletePerishedProduct() {
		GregorianCalendar calendar = new java.util.GregorianCalendar();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.add(Calendar.DATE, -1);
		int[] tab = new int[this.fridgeContent.size()];
		int i = -1;
		int j = 0;
		int k = 0;
		for (ProductAbstract p : this.fridgeContent) {
			i++;
			if(p instanceof ProductPerishable){
				if(((ProductPerishable) p).getDatePerishment().getTimeInMillis() < calendar.getTimeInMillis() ){
					
					tab[j]=i;
					j++;

				}
			}
		}

		for(i = 0 ; i<j; i++){
			System.out.println(tab[i]);
			this.deleteProduct(tab[i]-k);
			k++;
				
			
			
		}
	}

	public void showListPerishedProductIn(int n) {
		GregorianCalendar calendar = new java.util.GregorianCalendar();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.add(Calendar.DATE, n-1);
		System.out.println("Liste périmés dans "+ n +" jours : ");
		for (ProductAbstract p : this.fridgeContent) {
			if(p instanceof ProductPerishable){
				if(((ProductPerishable) p).getDatePerishment().getTimeInMillis() < calendar.getTimeInMillis() ){
					
					System.out.println(p);
				}
			}
			
			
			
		}
		
		

	}

	public void sortProductByAddingDate() {
		Comparator<ProductAbstract> comparatorAddingDate = new Comparator<ProductAbstract>() {
			@Override
			public int compare(ProductAbstract p1, ProductAbstract p2) {
				return p1.getDateAjout().compareTo(p2.getDateAjout());
			}
		};
		Collections.sort(this.fridgeContent, comparatorAddingDate);

	}

	public void sortProductByPerishmentDate() {
		Comparator<ProductAbstract> comparatorPerishmentDate = new Comparator<ProductAbstract>() {
			@Override
			public int compare(ProductAbstract p1, ProductAbstract p2) {
				if (p1 instanceof ProductPerishable
						&& p2 instanceof ProductPerishable) {

					return ((ProductPerishable) p1).getDatePerishment()
							.compareTo(
									((ProductPerishable) p2)
											.getDatePerishment());

				} else if (p1 instanceof ProductUnPerishable
						&& p2 instanceof ProductPerishable) {
					return 1;

				} else if (p1 instanceof ProductPerishable
						&& p2 instanceof ProductUnPerishable) {
					return -1;
				} else {
					return 0;
				}

			}
		};

		Collections.sort(this.fridgeContent, comparatorPerishmentDate);
	}

	public void sortProductByType() {
		Comparator<ProductAbstract> comparatorType = new Comparator<ProductAbstract>() {
			@Override
			public int compare(ProductAbstract p1, ProductAbstract p2) {
				return p1.getTypeProduct().compareTo(p2.getTypeProduct());
			}
		};

		Collections.sort(this.fridgeContent, comparatorType);
	}

	public void sortProductByQuantity(final boolean increase) {
		Comparator<ProductAbstract> comparatorQuantity = new Comparator<ProductAbstract>() {
			@Override
			public int compare(ProductAbstract p1, ProductAbstract p2) {
				if (increase) {
					return Integer.compare(p1.getQuantity(), p2.getQuantity());
				} else {
					return Integer.compare(p2.getQuantity(), p1.getQuantity());

				}
			}
		};

		Collections.sort(this.fridgeContent, comparatorQuantity);
	}

	@Override
	public String toString() {
		String res = "";
		int i = 1;
		res += "#####################\n";
		res += "The Fridge contents : \n";
		res += "#####################\n";

		for (ProductAbstract p : this.fridgeContent) {
			res += "#" + i;
			res += p.toString() + "\n";
			i++;
		}

		return res;
	}

}
