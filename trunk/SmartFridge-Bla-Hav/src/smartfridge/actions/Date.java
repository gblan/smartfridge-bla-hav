package smartfridge.actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Date {

	private static Locale locale = Locale.getDefault();
	private static Date actuelle = new Date();
	private static DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

	public static String date() {
		String date = dateformat.format(actuelle);
		return date;
	}

}
