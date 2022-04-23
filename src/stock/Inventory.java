package stock;

import java.util.ArrayList;
import java.util.List;


public class Inventory {
	
	//restore

	private List<Stock> stocks = new ArrayList<Stock>();
	private int maxStocks;
	private int currentStocks;
	private String name;
	
	public Inventory() {}
	
	public Inventory(int maxStocks) {
		this.maxStocks = maxStocks;
	}
	
	public Inventory(String name, int maxStocks) {
		this.name = name;
		this.maxStocks = maxStocks;
	}

	public List<Stock> getStocks() {
		return stocks;
	}
	
	public boolean addStock(Stock s) {
		if(fitStock()) {
			stocks.add(s);
			currentStocks++;
			return true;
		} else return false;
	}

	public String getName() {
		return name;
	}
	
	public Stock getStockById(int id) {
		for(Stock stock : stocks) {
			if(stock.getId() == id) {
				return stock;
			}
		}
		return null;
	}
	
	public boolean fitStock() {
		if(currentStocks < maxStocks)
			return true;
		else return false;
	}
	
}
