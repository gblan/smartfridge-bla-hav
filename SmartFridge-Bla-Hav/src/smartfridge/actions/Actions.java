package smartfridge.actions;

import smartfridge.enu.TypeActionEnum;
import smartfridge.product.ProductAbstract;

public class Actions {

	private ProductAbstract product;
	private TypeActionEnum enu;
		
	public Actions(ProductAbstract product, TypeActionEnum enu) {
		this.product = product;
		this.enu = enu;
	}

	public static String printListActions() {
		String res = "";

		res += "#####################\n";
		res += "Actions available : \n";
		res += "#####################\n";
		res += "'a' - add\t\t\t\t's'   - display content\n";
		res += "'r' - remove\t\t\t\t'sda' - sorted by date added\n";
		res += "'re' - remove expired\t\t\t'sed' - sorted by expiration date\n";
		res += "'i' - increase quantity\t\t\t'siq' - sorted by increasing quantity\n";
		res += "'d' - decrease quantity\t\t\t'sqd' - sorted by decreasing quantity\n";
		res += "'ck' - check expiration\t\t\t'st'  - sorted by type\n";
		res += "----------------------------------------------------------------------------\n";
		res += "'ud' - unDo\t'rd' - reDo\t'sa' - save\t'lo' - load\t'ex' - exit\n";

		return res;
	}

	public TypeActionEnum getOppositeAction(TypeActionEnum enu) {
		switch (enu) {
		case ADD:
			return TypeActionEnum.REMOVE;
		case REMOVE:
			return TypeActionEnum.ADD;
		case INCREASE_QUANTITY:
			return TypeActionEnum.DECREASE_QUANTITY;
		case DECREASE_QUANTITY:
			return TypeActionEnum.INCREASE_QUANTITY;
		default:
			return null;
		}
	}
}
