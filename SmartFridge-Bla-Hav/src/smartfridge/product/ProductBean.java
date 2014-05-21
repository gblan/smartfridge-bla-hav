package smartfridge.product;

import java.util.Date;

import smartfridge.enu.TypeProductEnum;
import smartfridge.enu.TypeQuantityEnum;

public abstract class ProductBean {

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


}
