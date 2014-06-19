package smartfridge.product;

import java.util.Calendar;
import java.util.GregorianCalendar;

import smartfridge.enu.TypeProductEnum;

public class ProductPerishable extends ProductAbstract {

	private static final long serialVersionUID = 6264276293944938696L;
	private GregorianCalendar datePerishment;

	public ProductPerishable(TypeProductEnum typeProduct, String productName,
			int quantity, GregorianCalendar datePerishment) {
		super(typeProduct, productName, quantity);
		datePerishment.add(Calendar.MONTH, -1);
		this.datePerishment = datePerishment;
	}

	public GregorianCalendar getDatePerishment() {
		return datePerishment;
	}

	@Override
	public String toString() {
		String tmp = super.toString();
		tmp += " --- " + this.datePerishment.get(Calendar.DATE) + "/"
				+ (this.datePerishment.get(Calendar.MONTH) + 1) + "/"
				+ this.datePerishment.get(Calendar.YEAR);

		return tmp;
	}

	@Override
	public int compareTo(ProductAbstract o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
