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

	public void setProductId(int productId) {
		this.productId = productId;
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

	private void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDateAjout() {
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
		this.dateAjout = CurrentDate.getCurrentDate();
	}

	@Override
	public String toString() {
		String res = "";

		res += "#" + this.getProductId() + " : " + this.quantity + " "
				+ this.typeQuantity.toString() + " - "
				+ this.typeProduct.toString() + " : " + this.productName;

		return res;
	}

	
}
