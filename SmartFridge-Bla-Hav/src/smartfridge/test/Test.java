package smartfridge.test;

import smartfridge.view.PerishedView;

public class Test {

	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		GregorianCalendar g = new GregorianCalendar(2014, 05, 20);
//
//		ProductPerishable p12 = new ProductPerishable(TypeProductEnum.MEATS,
//				"rognons2", 500, g);
//		g.set(14, 05, 20);
//		ProductPerishable p = new ProductPerishable(TypeProductEnum.FISH,
//				"Colin", 150, g);
//		g.set(2016, 05, 25);
//
//		ProductPerishable p2 = new ProductPerishable(TypeProductEnum.DRINKS,
//				"rhum", 3, g);
//		ProductUnPerishable p3 = new ProductUnPerishable(
//				TypeProductEnum.DRINKS, "rhum blanc", 1);
//		g.set(2014, 05, 20);
//
//		ProductPerishable p4 = new ProductPerishable(TypeProductEnum.MEATS,
//				"rognons", 500, g);
//
//		Fridge f = new Fridge();
//		FridgeManager fm = new FridgeManager(f);
//		fm.executeAction(TypeActionEnum.ADD, p, 0);
//		fm.executeAction(TypeActionEnum.ADD, p2, 0);
//		
//
//
//
//		System.out.println(f);
//		fm.executeAction(TypeActionEnum.ADD, p3, 0);
//		fm.executeAction(TypeActionEnum.ADD, p4, 0);
//		fm.executeAction(TypeActionEnum.ADD, p12, 0);
//		
//		System.out.println(f);
//
//		//fm.executeAction(TypeActionEnum.REMOVE,p2,0 );
//
//		fm.executeAction(TypeActionEnum.DECREASE_QUANTITY, p3, 30);
//		
//		
//
//		System.out.println(f);
//		fm.unDoAction();
//
//		System.out.println(f);
//		fm.unDoAction();
//		System.out.println(f);
//		fm.reDoAction();
//		System.out.println(f);
//
//		fm.reDoAction();
//		System.out.println(f);
//
//
//
//		//fm.addProduct(p2);
//		//fm.addProduct(p3);
//		//fm.addProduct(p4);
//		//fm.addProduct(p12);
//		fm.executeAction(TypeActionEnum.INCREASE_QUANTITY, p3, 50);
//
//
//		System.out.println(fm.showUndoList());
//		
//
//		
//		System.out.println(f);
//		
//		fm.unDoAction();
//		System.out.println(f);
//		FridgeUtils.saveFridge(f);
//
//		// System.out.println(Actions.printListActions());
//
//	}
	
	public static void main(String[] args) {
		PerishedView d = new PerishedView();
	}

}
