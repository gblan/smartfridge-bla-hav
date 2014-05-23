package smartfridge.test;

import java.util.GregorianCalendar;

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

		ProductPerishable p = new ProductPerishable(TypeProductEnum.FISH, "Colin", TypeQuantityEnum.GRAMMES, 150, new GregorianCalendar(2014, 05, 25));
		ProductPerishable p2 = new ProductPerishable(TypeProductEnum.DRINKS, "rhum", TypeQuantityEnum.LITRES, 3, new GregorianCalendar(2016, 05, 25));
		ProductPerishable p4 = new ProductPerishable(TypeProductEnum.DIARY, "Milk", TypeQuantityEnum.LITRES, 3, new GregorianCalendar(2013, 05, 25));
		ProductPerishable p5 = new ProductPerishable(TypeProductEnum.DRINKS, "Jus de fruit", TypeQuantityEnum.LITRES, 3, new GregorianCalendar(2014, 05, 29));
		ProductPerishable p6 = new ProductPerishable(TypeProductEnum.DRINKS, "Jus d'abricots", TypeQuantityEnum.LITRES, 3, new GregorianCalendar(2014, 05, 22));

		ProductUnPerishable p3 = new ProductUnPerishable(TypeProductEnum.DRINKS, "rhum blanc", TypeQuantityEnum.LITRES, 1);
		Fridge f = new Fridge();
		f.addProduct(p);
		f.addProduct(p2);
		f.addProduct(p3);
		f.addProduct(p4);
		f.addProduct(p5);
		f.addProduct(p6);

		System.out.println(f);
		
		f.showListPerishedProductIn(6);
		f.deletePerishedProduct();
		
		System.out.println(f);
		

	}

}
