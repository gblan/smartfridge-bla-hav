package smartfridge.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import smartfridge.fridge.Fridge;

public class FridgeUtils {

	public static void saveFridge(Fridge fridge) {

		ObjectOutputStream oos = null;

		try {
			final FileOutputStream fichier = new FileOutputStream("fridge.ser");
			oos = new ObjectOutputStream(fichier);
			oos.writeObject(fridge);
			oos.flush();
		} catch (final java.io.IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.flush();
					oos.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}

		}
	}

	public static Fridge loadFridge() {
		ObjectInputStream ois = null;
		Fridge fridge = null;
		try {
			final FileInputStream fichier = new FileInputStream("fridge.ser");
			ois = new ObjectInputStream(fichier);
			fridge = (Fridge) ois.readObject();
		} catch (final java.io.IOException e) {
			e.printStackTrace();
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
		}
		return fridge;
	}
}
