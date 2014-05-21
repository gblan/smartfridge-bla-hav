package smartfridge.product;

import java.util.Date;

import smartfridge.enu.TypeProductEnum;
import smartfridge.enu.TypeQuantityEnum;

public abstract class ProductBean {

	TypeProductEnum typeProduct;
	String productName;
	TypeQuantityEnum typeQuantity;
	int quantity;
	Date dateAjout;

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

}
