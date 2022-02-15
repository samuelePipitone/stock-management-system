package stock;

import myException.WeightlessException;
import utility.Dimensione;

public class Item {

	private String barcode;
	private String description;
	private String name;
	private double weight;
	private Dimensione dimensione = new Dimensione();
	
	public Item() {}
	
	public Item(String barcode, String name) {
		this.barcode = barcode;
		this.name = name;
	}
	
	public Item (String barcode, String description, String name, double weight, Dimensione dimensione) {
		this.barcode = barcode;
		this.name = name;
		this.description = description;
		this.weight = weight;
		this.dimensione = dimensione;
	}
	
	public Item (String barcode, String name, double weight, Dimensione dimensione) {
		this.barcode = barcode;
		this.name = name;
		this.weight = weight;
		this.dimensione = dimensione;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Dimensione getDimensione() {
		return dimensione;
	}
	
	public boolean isWeightfull() throws WeightlessException {
		if(this.weight <= 0) {
			throw new WeightlessException("Il tuo oggetto non ha peso");
		}
		return true;
	}
	
}
