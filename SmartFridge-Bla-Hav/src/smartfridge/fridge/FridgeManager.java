package smartfridge.fridge;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;

import smartfridge.actions.Actions;
import smartfridge.enu.TypeActionEnum;
import smartfridge.product.ProductAbstract;
import smartfridge.product.ProductPerishable;
import smartfridge.product.ProductUnPerishable;

public class FridgeManager {

	private Fridge fridge;
	private List<Actions> unDo;
	private List<Actions> reDo;

	public FridgeManager(Fridge f) {
		this.fridge = f;
		unDo = new ArrayList<Actions>();
		reDo = new ArrayList<Actions>();

	}

	public void executeAction(TypeActionEnum enu,
			ProductAbstract addProduct, int setQuantity) {
		int idProduct = getIdProduct(addProduct);;
		switch (enu) {
		case ADD:
			addProduct(addProduct);
			idProduct = getIdProduct(addProduct);
			unDo.add(new Actions(addProduct, enu , idProduct));
			
			break;

		case REMOVE:

			unDo.add(new Actions(this.fridge.getFridgeContent().get(idProduct), enu , idProduct));
			deleteProduct(idProduct);
			break;
		case INCREASE_QUANTITY:
			unDo.add(new Actions(this.fridge.getFridgeContent().get(idProduct).clone(), enu , idProduct));

			fridge.getFridgeContent().get(idProduct)
					.increaseQuantity(setQuantity);
			break;

		case DECREASE_QUANTITY:
			unDo.add(new Actions(this.fridge.getFridgeContent().get(idProduct).clone(), enu , idProduct));

			fridge.getFridgeContent().get(idProduct)
					.decreaseQuantity(setQuantity);
			break;

		default:
		}
	}

	public void unDoAction() {
		Actions actions = unDo.get(unDo.size() - 1);

		int previousQuantity;
		int actualQuantity;

		reDo.add(new Actions(actions.getProduct(), Actions.getOppositeAction(actions.getEnu()) , actions.getIdProduit()));

		
		switch (Actions.getOppositeAction(actions.getEnu())) {
		case ADD:
			addProduct(unDo.get(unDo.size()- 1).getProduct(),actions.getIdProduit());
			break;

		case REMOVE:
			deleteProduct(actions.getIdProduit());
			break;

		case INCREASE_QUANTITY:	
			previousQuantity = unDo.get(unDo.size() - 1).getProduct().getQuantity();
			actualQuantity = fridge.getFridgeContent().get(actions.getIdProduit())
				.getQuantity();
			//System.out.println(previousQuantity  + "actual" + actualQuantity);
			fridge.getFridgeContent().get(actions.getIdProduit())
					.increaseQuantity(previousQuantity - actualQuantity);
			break;


		case DECREASE_QUANTITY:
			previousQuantity = unDo.get(unDo.size() - 1).getProduct().getQuantity();
			actualQuantity = fridge.getFridgeContent().get(actions.getIdProduit())
					.getQuantity();
			
			fridge.getFridgeContent().get(actions.getIdProduit())
					.decreaseQuantity(actualQuantity - previousQuantity);
			break;

		default:
		}
	}
	
	public int getIdProduct(ProductAbstract product){
		int i = 0;
		for(ProductAbstract p : this.fridge.getFridgeContent()){
			if(p == product){
				return i;
			}
			i++;
			
		}
		return -1;
		
	}

	public void addProduct(ProductAbstract p) {
		this.fridge.getFridgeContent().add(p);
	}

	public void addProduct(ProductAbstract p, int idAction){
		this.fridge.getFridgeContent().add(idAction, p);
	}
	public void deleteProduct(int n) {
		this.fridge.getFridgeContent().remove(n);
	}

	public void deletePerishedProduct() {
		GregorianCalendar calendar = new java.util.GregorianCalendar();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.add(Calendar.DATE, -1);
		int[] tab = new int[this.fridge.getFridgeContent().size()];
		int i = -1;
		int j = 0;
		int k = 0;
		for (ProductAbstract p : this.fridge.getFridgeContent()) {
			i++;
			if (p instanceof ProductPerishable) {
				if (((ProductPerishable) p).getDatePerishment()
						.getTimeInMillis() < calendar.getTimeInMillis()) {

					tab[j] = i;
					j++;

				}
			}
		}

		for (i = 0; i < j; i++) {
			System.out.println(tab[i]);
			deleteProduct(tab[i] - k);
			k++;

		}
	}

	public void showListPerishedProductIn(int n) {
		GregorianCalendar calendar = new java.util.GregorianCalendar();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.add(Calendar.DATE, n - 1);
		System.out.println("Liste périmés dans " + n + " jours : ");
		for (ProductAbstract p : this.fridge.getFridgeContent()) {
			if (p instanceof ProductPerishable) {
				if (((ProductPerishable) p).getDatePerishment()
						.getTimeInMillis() < calendar.getTimeInMillis()) {

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
		Collections.sort(this.fridge.getFridgeContent(), comparatorAddingDate);

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

		Collections.sort(this.fridge.getFridgeContent(),
				comparatorPerishmentDate);
	}

	public void sortProductByType() {
		Comparator<ProductAbstract> comparatorType = new Comparator<ProductAbstract>() {
			@Override
			public int compare(ProductAbstract p1, ProductAbstract p2) {
				return p1.getTypeProduct().compareTo(p2.getTypeProduct());
			}
		};

		Collections.sort(this.fridge.getFridgeContent(), comparatorType);
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

		Collections.sort(this.fridge.getFridgeContent(), comparatorQuantity);
	}
	
	public String showUndoList(){
		String res = "";
		for(Actions act : this.unDo){
			res += act.toString()+"\n";
		}
		
		return res;
	}
	public String showRedoList(){
		String res = "";
		for(Actions act : this.reDo){
			res += act.toString()+"\n";
		}
		
		return res;
	}

}
