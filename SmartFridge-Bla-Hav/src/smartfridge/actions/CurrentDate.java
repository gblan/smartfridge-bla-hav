package smartfridge.actions;

import java.util.Date;

public class CurrentDate {

	private static Date actuelle = new Date();

	public static Date getCurrentDate() {
		return actuelle;
	}

}
