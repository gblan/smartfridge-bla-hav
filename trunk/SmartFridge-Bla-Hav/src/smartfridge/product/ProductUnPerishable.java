package smartfridge.product;

import smartfridge.enu.TypeProductEnum;
import smartfridge.enu.TypeQuantityEnum;

public class ProductUnPerishable extends ProductAbstract{

	public ProductUnPerishable(TypeProductEnum typeProduct, String productName,
			TypeQuantityEnum typeQuantity, int quantity) {
		super(typeProduct, productName, typeQuantity, quantity);
	}

	@Override
	public int compareTo(ProductAbstract o) {
		// TODO Auto-generated method stub
		return 0;
	}



}