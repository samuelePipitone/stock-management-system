package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import myException.AdimensionalException;
import myException.NoFitException;
import myException.NoInventoryFoundException;
import myException.NoStockIdFound;
import stock.Inventory;
import stock.Item;
import stock.Shelf;
import stock.Stock;
import utility.OperationList;
import utility.Utility;

public class Test {

	public static void main(String[] args) throws NoInventoryFoundException,
	NoStockIdFound, AdimensionalException, NoFitException {
		
		//Lists of my objects
		List<Inventory> inventories = new ArrayList<Inventory>();
		
		//My singleton
		Inventory inventory_Milano = new Inventory("Milano", 8);
		inventories.add(inventory_Milano);
		Stock first_stock = new Stock(1); 
		inventory_Milano.addStock(first_stock);
		
		//Variables
		int currentOperation = 1;
		String currentInventory;
		int stockById;
		int n = 0;
		
		//Variables for item
		int numStock;
		
		//current items
		Stock currentStockOperation = new Stock();
		Inventory currentInventoryOperation = new Inventory();
		
		//Other 
		OperationList opObject = new OperationList();
		List<String> operations = opObject.getOperations();
		Scanner scLine = new Scanner(System.in);
		Scanner scDouble = new Scanner(System.in);
		Scanner scInt = new Scanner(System.in);
		
		System.out.println("Good morning, welcome to my personal stock management system");
		System.out.println("For the moment you have one inventory: Milano and 1 empty stocks inside");
		System.out.println("The stocks have a space of 4 shelf each"); //DA MODIFICARE, AGGIUNGI VARI TIPI DI STOCKS
		
		while(currentOperation != 0) {
			
			System.out.println("Choose between one of the operation with the number!");
			
			for(String operation : operations) {
				System.out.println(operation);
			}
			
				currentOperation = scInt.nextInt();
				
				switch(currentOperation) {
				
				case 0: {
					currentOperation = 0;
					break;
				}
				
				//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
				
				case 1: {
						//text ------------------------------------------------------------------------
						System.out.println("Choose a inventory by name: ");
						Utility.showInventory(inventories);
						
						currentInventory = scLine.nextLine();
						
						//control name inventory
						for(Inventory inventory : inventories) {
							if(inventory.getName().equals(currentInventory)) {
								currentInventoryOperation = inventory;
								n++;
							} 
						}
						if(n == 0) {
							throw new NoInventoryFoundException("No name match");
						}
						n = 0;
						
						//text------------------------------------------------------------------------
						System.out.println("Choose a stock number: ");
						Utility.showStocks(inventory_Milano.getStocks());
						
						stockById = scInt.nextInt();
						
						//control stock id
						for(Stock currentStock2 : inventory_Milano.getStocks()) {
							if(currentStock2.getId() == stockById) {
								currentStockOperation = currentStock2;
								n++;
							} 
						}
						if(n == 0) {
							throw new NoStockIdFound("No id match");
						}
						n = 0;
						
						//Creation of item------------------------------------------------------------
						Item item = Utility.createItem();
						
						//Set item---------------------------------------------------------------------
						if(currentStockOperation.fitItem(item)) {
							currentStockOperation.addItem(item);
						} else {
							throw new NoFitException("Your item can't fit this stock");
						}
						
						System.out.println(item.getName() + " è stato aggiunto allo stock " + 
								currentStockOperation.getId() + "\n");
						
						//Reset temporary value of stock and inventory
						currentStockOperation = null;
						currentInventoryOperation = null;
						break;
					}
				
				//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
				
				case 2: {
					
					System.out.println("Choose a inventory by name: ");
					Utility.showInventory(inventories);
					
					currentInventory = scLine.nextLine();
					
					//control name inventory
					for(Inventory inventory : inventories) {
						if(inventory.getName().equals(currentInventory)) {
							currentInventoryOperation = inventory;
							n++;
						} 
					}
					if(n == 0) {
						throw new NoInventoryFoundException("No name match");
					}
					n = 0;
					
					System.out.println("digita un numero per il tuo stock!");
					numStock = scInt.nextInt();
					
					if(currentInventoryOperation.getStockById(numStock) == null) {
						Stock stock = new Stock(numStock);
						for(Inventory inventory : inventories) {
							if(inventory.getName().equals(currentInventory)) {
								if(inventory.addStock(stock)) {
									System.out.println("Perfect! your stock is added");
								}
								else {
									System.out.println("No more space for your stock!");
								}
							} 
						}
						
					} else {
						System.out.println("This id is already present!");
						break;
					}
					currentStockOperation = null;
					currentInventoryOperation = null;
					break;
				}
				
				//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
				
				case 3: {
					System.out.println("Choose a inventory by name: ");
					Utility.showInventory(inventories);
					
					currentInventory = scLine.nextLine();
					
					//control name inventory
					for(Inventory inventory : inventories) {
						if(inventory.getName().equals(currentInventory)) {
							currentInventoryOperation = inventory;
							n++;
						} 
					}
					if(n == 0) {
						throw new NoInventoryFoundException("No name match");
					}
					n = 0;
					
					for(Stock stock : currentInventoryOperation.getStocks()) {
						for(Shelf shelf : stock.getShelfs()) {
							for(Item item : shelf.getAllItems()) {
								System.out.println(item.getName());
							}
						}
					}
					currentStockOperation = null;
					currentInventoryOperation = null;
					break;
				}
				
				//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
				
				case 4: {
					for(Inventory inventory : inventories) {
						System.out.println(++n + " " + inventory.getName());
					}
					n = 0;
					break;
				}
				
				//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
				
				case 5: {
					System.out.println("Choose a inventory by name: ");
					Utility.showInventory(inventories);
					
					currentInventory = scLine.nextLine();
					
					//control name inventory
					for(Inventory inventory : inventories) {
						if(inventory.getName().equals(currentInventory)) {
							currentInventoryOperation = inventory;
							n++;
						} 
					}
					if(n == 0) {
						throw new NoInventoryFoundException("No name match");
					}
					n = 0;
					
					for(Stock stock : currentInventoryOperation.getStocks()) {
						System.out.println("Stock: " + stock.getId());
					}
					currentStockOperation = null;
					currentInventoryOperation = null;
					break;
				}
				
				//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
				
				case 6: {
					for(Inventory inventory : inventories) {
						for(Stock stock : inventory.getStocks()) {
							for(Shelf shelf : stock.getShelfs()) {
								for(Item item : shelf.getAllItems()) {
									System.out.println(item.getName());
								}
							}
						}
					}
					currentStockOperation = null;
					currentInventoryOperation = null;
					break;
				}
				
				//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
				
				case 7: {
					System.out.println("Choose a name for your new inventory");
					currentInventory = scLine.nextLine();
					
					//control name inventory
					for(Inventory inventory : inventories) {
						if(inventory.getName().equals(currentInventory)) {
							System.out.println("This name is already in use");
							break;
						} 
					}
					System.out.println("Perfect! now digit the max number of stocks it can hold");
					int maxSlot = scInt.nextInt();
					Inventory newInventory = new Inventory(currentInventory, maxSlot);
					inventories.add(newInventory);
					System.out.println(currentInventory + " has been created!");
					
					currentStockOperation = null;
					currentInventoryOperation = null;
					break;
				}
				
				//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
				
				default: {
						System.out.println("Error, no operation found");
						currentOperation = 0;
						break;
					}
				}
		}
		
		System.out.println("Thank you for using my little application, see you soon!");
		scLine.close();
		scDouble.close();
		scInt.close();
	}
}
