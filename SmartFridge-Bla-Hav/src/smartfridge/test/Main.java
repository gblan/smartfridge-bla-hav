package smartfridge.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;

import smartfridge.actions.Actions;
import smartfridge.enu.TypeActionEnum;
import smartfridge.enu.TypeProductEnum;
import smartfridge.fridge.Fridge;
import smartfridge.fridge.FridgeManager;
import smartfridge.product.ProductPerishable;
import smartfridge.product.ProductUnPerishable;
import smartfridge.utils.FridgeUtils;

public class Main {

	private static void add(FridgeManager fm) {
		BufferedReader console = new BufferedReader(new InputStreamReader(
				System.in));
		String line[];
		
		System.out.println("ADDING -- Type of Product:");
		for(int i = 0 ; i<TypeProductEnum.values().length ; i++) {
			System.out.println(i + " - " + TypeProductEnum.values()[i]);
		}
		
		System.out.println();
		System.out.println("To add a new product, follow this format and press enter :");
		System.out.println("Type#;Name ;Expiration(dd/MM/yyyy)(optional);Quantity(optional)");
		fm.clearRedoList();
		try {
			line = console.readLine().split(";");
			if(line[2].equalsIgnoreCase(" ")){
				if(line[3].equalsIgnoreCase(" ")) {
					fm.executeAction(TypeActionEnum.ADD, new ProductUnPerishable(TypeProductEnum.values()[Integer.parseInt(line[0])], line[1], 1), 0);					
				}
				else{
					fm.executeAction(TypeActionEnum.ADD, new ProductUnPerishable(TypeProductEnum.values()[Integer.parseInt(line[0])], line[1], Integer.parseInt(line[3])), 0);					

				}
			}
			else{
				String date[] = line[2].split("/");
				GregorianCalendar calendar = new GregorianCalendar(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
				if(line[3] == " ") {
					fm.executeAction(TypeActionEnum.ADD, new ProductPerishable(TypeProductEnum.values()[Integer.parseInt(line[0])], line[1],1, calendar), 0);					
				}
				else{
					fm.executeAction(TypeActionEnum.ADD, new ProductPerishable(TypeProductEnum.values()[Integer.parseInt(line[0])], line[1],Integer.parseInt(line[3]), calendar), 0);					

					
				}
				
			}
		} catch (IOException e) {
			System.err.println("Id Invalide");
		}

	}

	private static void remove(FridgeManager fm) {
		BufferedReader console = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		System.out.println("Select the ID of the product you want to remove : ");
		fm.clearRedoList();
		try {
			line = console.readLine();
			int id = Integer.parseInt(line);
			fm.executeAction(TypeActionEnum.REMOVE, fm.getFridge().getFridgeContent().get(id - 1), 0);
		} catch (IOException e) {
			System.err.println("Id Invalide");
		}
	}

	private static void increaseQuantity(FridgeManager fm) {
		BufferedReader console = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		System.out.println("Select the ID of the product you want to increase the quantity : ");
		fm.clearRedoList();
		try {
			line = console.readLine();
			int id = Integer.parseInt(line);
			fm.executeAction(TypeActionEnum.INCREASE_QUANTITY, fm.getFridge().getFridgeContent().get(id - 1), 1);
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
		fm.clearRedoList();
		try {
			line = console.readLine();
			int id = Integer.parseInt(line);
			
			fm.executeAction(TypeActionEnum.DECREASE_QUANTITY, fm.getFridge().getFridgeContent().get(id - 1), 1);
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
			System.out.println(fm.showListPerishedProductIn(nbDays));
		} catch (IOException e) {
			line = "Reading error";
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		FridgeManager fm = new FridgeManager(new Fridge());
		BufferedReader console = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		boolean exit = false;
		while(!exit ){
			exit = false;
			
			System.out.println(fm.getFridge());
			System.out.println(Actions.printListActions());
			
			System.out.println("Select an action in the above list: ");
			try {
				
				line = console.readLine();
				switch (line) {
				case "a":	add(fm); break; // done
				case "r":	remove(fm); break; // done
				case "re":  fm.deletePerishedProduct();	break; // done
				case "i":	increaseQuantity(fm); break; // done
				case "d":	decreaseQuantity(fm); break; // done
				case "ck":	checkExpiration(fm); break; // done
				case "st":	fm.sortProductByType(); break; //done
				case "sda": fm.sortProductByAddingDate();	break; //done
				case "sed":	fm.sortProductByPerishmentDate(); break; //done
				case "siq":	fm.sortProductByQuantity(true); break; //done
				case "sqd":	fm.sortProductByQuantity(false); break; //done
				case "ud":	fm.unDoAction(); break; // done
				case "rd":	fm.reDoAction(); break; // done
				case "sa":	FridgeUtils.saveFridge(fm.getFridge()); break; // done
				case "lo":	fm.setFridge(FridgeUtils.loadFridge()); break; // done
				case "ex":	exit = true; break;// ça marche
				default:
					System.out.println("Unrecognize command, try again");
					break;
				}
			
			} catch (IOException e) {
				line = "Reading error";
				e.printStackTrace();
			}
		}
		System.out.println("See you soon");
	}
}
