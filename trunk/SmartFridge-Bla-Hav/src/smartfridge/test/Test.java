package smartfridge.test;

import java.util.Date;

import smartfridge.enu.TypeProductEnum;
import smartfridge.enu.TypeQuantityEnum;
import smartfridge.fridge.Fridge;
import smartfridge.product.ProductPerishable;
import smartfridge.product.ProductUnPerishable;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ProductPerishable p = new ProductPerishable(TypeProductEnum.FISH, "Colin", TypeQuantityEnum.GRAMMES, 150, new Date(2014, 05, 25));
		ProductPerishable p2 = new ProductPerishable(TypeProductEnum.DRINKS, "rhum", TypeQuantityEnum.LITRES, 3, new Date(2016, 05, 25));
		ProductUnPerishable p3 = new ProductUnPerishable(TypeProductEnum.DRINKS, "rhum blanc", TypeQuantityEnum.LITRES, 1);
		Fridge f = new Fridge();
		f.addProduct(p);
		f.addProduct(p2);
		f.addProduct(p3);
		System.out.println(f);
		f.getFridgeContent().get(2).increaseQuantity(2);
		f.getFridgeContent().get(0).decreaseQuantity(100);

		System.out.println(f);
		
		f.deleteProduct(0);
		System.out.println(f);

	}

}
