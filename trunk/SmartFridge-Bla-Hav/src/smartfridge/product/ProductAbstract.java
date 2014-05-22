package smartfridge.product;

import java.util.Date;

import smartfridge.actions.CurrentDate;
import smartfridge.enu.TypeProductEnum;
import smartfridge.enu.TypeQuantityEnum;

public abstract class ProductAbstract implements Comparable<ProductAbstract>{

	private int productId;
	private TypeProductEnum typeProduct;
	private String productName;
	private TypeQuantityEnum typeQuantity;
	private int quantity;
	private Date dateAjout;

	public int getProductId() {
		return productId;
	}

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

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDateAjout() {
		return dateAjout;
	}

	public ProductAbstract(TypeProductEnum typeProduct, String productName,
			TypeQuantityEnum typeQuantity, int quantity) {
		this.typeProduct = typeProduct;
		this.productName = productName;
		this.typeQuantity = typeQuantity;
		this.quantity = quantity;
		this.dateAjout = CurrentDate.getCurrentDate();
	}

	@Override
	public String toString() {
		String res = "";

		res += "#" + this.productId + " : " + this.quantity + " "
				+ this.typeQuantity.toString() + " - "
				+ this.typeProduct.toString() + " : " + this.productName;

		return res;
	}
	
}
