package smartfridge.product;

import java.io.Serializable;
import java.util.GregorianCalendar;

import smartfridge.enu.TypeProductEnum;
import smartfridge.enu.TypeQuantityEnum;

public abstract class ProductAbstract implements Comparable<ProductAbstract>, Serializable{

	private static final long serialVersionUID = -2036680820842552707L;
	private TypeProductEnum typeProduct;
	private String productName;
	private TypeQuantityEnum typeQuantity;
	private int quantity;
	private GregorianCalendar dateAjout;

	public TypeProductEnum getTypeProduct() {
		return typeProduct;
	}

	public String getProductName() {
		return productName;
	}

	public TypeQuantityEnum getTypeQuantity() {
		return typeQuantity;
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
		this.setQuantity(this.getQuantity()+ quantityToAdd);
	}

	public void decreaseQuantity(int quantityToDecrease) {
		this.setQuantity(this.getQuantity()- quantityToDecrease);
	}

	public ProductAbstract(TypeProductEnum typeProduct, String productName,
			TypeQuantityEnum typeQuantity, int quantity) {
		this.typeProduct = typeProduct;
		this.productName = productName;
		this.typeQuantity = typeQuantity;
		this.quantity = quantity;
		this.dateAjout = new GregorianCalendar();
	}

	@Override
	public String toString() {
		String res = "";

		res += " : " + this.quantity + " "
				+ this.typeQuantity.toString() + " - "
				+ this.typeProduct.toString() + " : " + this.productName;

		return res;
	}

	
}
