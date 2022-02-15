package stock;

import java.util.ArrayList;
import java.util.List;

import utility.Dimensione;

public class Shelf {

	double maxWeight;
	double layer;
	double currentWeight;
	Dimensione dimension;
	double currentX;
	double maxX;
	double maxY;
	double maxZ;
	List <Item> items = new ArrayList<Item>();
	
	public Shelf() {}
	
	public Shelf(double maxWeight, double layer, Dimensione dimension) {
		this.maxWeight = maxWeight;
		this.layer = layer;
		this.currentWeight = 0;
		this.dimension = dimension;
		this.currentX = 0;
		this.maxX = dimension.getX();
		this.maxY = dimension.getY();
		this.maxZ = dimension.getZ();
	}

	public double getMaxWeight() {
		return maxWeight;
	}

	public double getLayer() {
		return layer;
	}
	
	public boolean fitItem(Item i) {
		double x = i.getWeight() + this.currentWeight;
		if(x >= maxWeight) {
			return false;
		} else if(maxX < (i.getDimensione().getX() + currentX) ||
				  maxY < i.getDimensione().getY() ||
				  maxZ < i.getDimensione().getZ()) {
			return false;
		} else {
			currentX = currentX + i.getDimensione().getX();
			return true;
		}
	}
	
	public void addItem(Item i) {
		items.add(i);
	}
	
	public List<Item> getAllItems(){
		return this.items;
	}
	
}
