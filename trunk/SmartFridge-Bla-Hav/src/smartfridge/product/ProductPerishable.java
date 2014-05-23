package smartfridge.product;

import java.util.Date;

import smartfridge.enu.TypeProductEnum;
import smartfridge.enu.TypeQuantityEnum;

public class ProductPerishable extends ProductAbstract {

	private Date datePerishment;

	public ProductPerishable(TypeProductEnum typeProduct, String productName,
			TypeQuantityEnum typeQuantity, int quantity, Date datePerishment) {
		super(typeProduct, productName, typeQuantity, quantity);
		this.datePerishment = datePerishment;
	}

	public Date getDatePerishment() {
		return datePerishment;
	}

	@Override
	public String toString() {
		String tmp = super.toString(); 
		tmp += " --- " + this.datePerishment.getDate() + "/" + this.datePerishment.getMonth() + "/"+ this.datePerishment.getYear();

		return tmp;
	}

	@Override
	public int compareTo(ProductAbstract o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
