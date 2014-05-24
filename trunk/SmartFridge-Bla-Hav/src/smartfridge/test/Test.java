package smartfridge.test;

import java.util.GregorianCalendar;

import smartfridge.enu.TypeProductEnum;
import smartfridge.enu.TypeQuantityEnum;
import smartfridge.fridge.Fridge;
import smartfridge.fridge.FridgeManager;
import smartfridge.product.ProductPerishable;
import smartfridge.product.ProductUnPerishable;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GregorianCalendar g = new GregorianCalendar(2014, 05, 20);

		ProductPerishable p12 = new ProductPerishable(TypeProductEnum.MEATS,
				"rognons2", TypeQuantityEnum.GRAMMES, 500, g);
		g.set(14, 05, 20);
		ProductPerishable p = new ProductPerishable(TypeProductEnum.FISH,
				"Colin", TypeQuantityEnum.GRAMMES, 150, g);
		g.set(2016, 05, 25);

		ProductPerishable p2 = new ProductPerishable(TypeProductEnum.DRINKS,
				"rhum", TypeQuantityEnum.LITRES, 3, g);
		ProductUnPerishable p3 = new ProductUnPerishable(
				TypeProductEnum.DRINKS, "rhum blanc", TypeQuantityEnum.LITRES,
				1);
		g.set(2014, 05, 20);

		ProductPerishable p4 = new ProductPerishable(TypeProductEnum.MEATS,
				"rognons", TypeQuantityEnum.GRAMMES, 500, g);

		Fridge f = new Fridge();
		FridgeManager fm = new FridgeManager(f);
		fm.addProduct(p);
		fm.addProduct(p2);
		fm.addProduct(p3);
		fm.addProduct(p4);
		fm.addProduct(p12);
		System.out.println(f);
		f.getFridgeContent().get(2).increaseQuantity(2);
		f.getFridgeContent().get(0).decreaseQuantity(100);

		System.out.println(f);

		// f.deleteProduct(0);
		// System.out.println(f);

		fm.sortProductByType();
		System.out.println(f);

		fm.sortProductByQuantity(true);
		System.out.println(f);

		fm.sortProductByAddingDate();

		// System.out.println(Actions.printListActions());

	}

}
