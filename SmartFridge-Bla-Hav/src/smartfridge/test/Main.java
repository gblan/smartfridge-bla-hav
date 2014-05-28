package smartfridge.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import smartfridge.actions.Actions;
import smartfridge.enu.TypeActionEnum;
import smartfridge.fridge.Fridge;
import smartfridge.fridge.FridgeManager;
import smartfridge.utils.FridgeUtils;

public class Main {

	private static void add() {

	}

	private static void remove(FridgeManager fm) {
		BufferedReader console = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		System.out.println("Select the ID of the product you want to remove : ");
		try {
			line = console.readLine();
			fm.executeAction(TypeActionEnum.REMOVE, null, 0);
		} catch (IOException e) {
			line = "Reading error";
			e.printStackTrace();
		}
	}

	private static void increaseQuantity(FridgeManager fm) {
		BufferedReader console = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		System.out.println("Select the ID of the product you want to increase the quantity : ");
		try {
			line = console.readLine();
			int ipProduct = Integer.parseInt(line);
			fm.executeAction(TypeActionEnum.INCREASE_QUANTITY, null, 1);
		} catch (IOException e) {
			line = "Reading error";
			e.printStackTrace();
		}
	}

	private static void decreaseQuantity(FridgeManager fm) {
		BufferedReader console = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		System.out.println("Select the ID of the product you want to increase the quantity : ");
		try {
			line = console.readLine();
			int ipProduct = Integer.parseInt(line);
			
			fm.executeAction(TypeActionEnum.DECREASE_QUANTITY, null, 1);
		} catch (IOException e) {
			line = "Reading error";
			e.printStackTrace();
		}
	}


	private static void checkExpiration(FridgeManager fm) {
		BufferedReader console = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		System.out.println("Select the number of days to check the expiration date");
		try {
			line = console.readLine();
			int nbDays = Integer.parseInt(line);
			fm.showListPerishedProductIn(nbDays);
		} catch (IOException e) {
			line = "Reading error";
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Fridge f = new Fridge();
		FridgeManager fm = new FridgeManager(f);
		BufferedReader console = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		boolean exit = false;
		while(!exit ){
			exit = false;
			
			System.out.println(f);
			System.out.println(Actions.printListActions());
			
			System.out.println("Select an action in the above list: ");
			try {
				
				line = console.readLine();
				switch (line) {
				case "a":	add(); break;
				case "r":	remove(fm); break;
				case "re":  fm.deletePerishedProduct();	break;
				case "i":	increaseQuantity(fm); break;
				case "d":	decreaseQuantity(fm); break;
				case "ck":	checkExpiration(fm); break;
				case "st":	fm.sortProductByType(); break;
				case "sda": fm.sortProductByAddingDate();	break;
				case "sed":	fm.sortProductByPerishmentDate(); break;
				case "sqi":	fm.sortProductByQuantity(true); break;
				case "sqd":	fm.sortProductByQuantity(false); break;
				case "ud":	fm.unDoAction(); break;
				case "rd":	fm.reDoAction(); break;
				case "sa":	FridgeUtils.saveFridge(f); break;
				case "lo":	f = FridgeUtils.loadFridge(); break;
				case "ex":	exit = true; break;
				default:
					System.out.println("Unrecognize command, try again");
					break;
				}
			
			} catch (IOException e) {
				line = "Reading error";
				e.printStackTrace();
			}
		}
	}
}
