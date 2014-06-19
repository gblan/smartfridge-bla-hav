package smartfridge.product;

import java.io.Serializable;
import java.util.GregorianCalendar;

import smartfridge.enu.TypeProductEnum;

public abstract class ProductAbstract implements Comparable<ProductAbstract>,
		Serializable, Cloneable {

	private static final long serialVersionUID = -2036680820842552707L;
	private TypeProductEnum typeProduct;
	private String productName;
	private int quantity;
	private GregorianCalendar dateAjout;

	public TypeProductEnum getTypeProduct() {
		return typeProduct;
	}

	public String getProductName() {
		return productName;
	}

	public int getQuantity() {
		return quantity;
	}

	private void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public GregorianCalendar getDateAjout() {
		return dateAjout;
	}

	public void increaseQuantity(int quantityToAdd) {
		this.setQuantity(this.getQuantity() + quantityToAdd);
	}

	public void decreaseQuantity(int quantityToDecrease) {
		this.setQuantity(this.getQuantity() - quantityToDecrease);
	}

	public ProductAbstract(TypeProductEnum typeProduct, String productName,
			int quantity) {
		this.typeProduct = typeProduct;
		this.productName = productName;
		this.quantity = quantity;
		this.dateAjout = new GregorianCalendar();
	}

	public ProductAbstract(TypeProductEnum typeProduct, String productName) {
		this.typeProduct = typeProduct;
		this.productName = productName;
		this.quantity = 1;
		this.dateAjout = new GregorianCalendar();
	}

	@Override
	public String toString() {
		String res = "";

		res += " : " + this.quantity + " " + " - "
				+ this.typeProduct.toString() + " : " + this.productName;

		return res;
	}

	public ProductAbstract clone() {
		ProductAbstract product = null;
		try {
			// On récupère l'instance à renvoyer par l'appel de la
			// méthode super.clone()
			product = (ProductAbstract) super.clone();
		} catch (CloneNotSupportedException cnse) {
			// Ne devrait jamais arriver car nous implémentons
			// l'interface Cloneable
			cnse.printStackTrace(System.err);
		}

		// on renvoie le clone
		return product;
	}

}
