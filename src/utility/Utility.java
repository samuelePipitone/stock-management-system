package utility;

import java.util.List;
import java.util.Scanner;

import stock.Inventory;
import stock.Item;
import stock.Stock;

public class Utility {

	//Static methods only
	
	public static void showInventory(List<Inventory> i) {
		int n = 0;
		for(Inventory inventory : i) {
			System.out.println(++n + ": " + inventory.getName());
		}
	}
	
	public static Item createItem() {
		Scanner scLine = new Scanner(System.in);
		Scanner scDouble = new Scanner(System.in);
		
		System.out.println("Perfect! now describe the item");
		System.out.println("Set the item name: ");
		String itemName = scLine.nextLine();
		System.out.println("Set the barcode number");
		String itemBarcode = scLine.nextLine();
		System.out.println("Set weight");
		double itemWeight = scDouble.nextDouble();
		System.out.println("Set x axis: ");
		double itemX = scDouble.nextDouble();
		System.out.println("Set y axis: ");
		double itemY = scDouble.nextDouble();
		System.out.println("Set z axis: ");
		double itemZ = scDouble.nextDouble();
		Dimensione itemDimension = new Dimensione(itemX, itemY, itemZ);
		Item item = new Item(itemBarcode, itemName, itemWeight, itemDimension);
		
		scLine.close();
		scDouble.close();
		
		return item;
	} 
	
	public static void showStocks(List<Stock> s) {
		for(Stock currentStock : s) {
			System.out.println(currentStock.getId());
		}
	}
	
}
