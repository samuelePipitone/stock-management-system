package stock;

import java.util.ArrayList;
import java.util.List;

import myException.AdimensionalException;
import utility.Dimensione;

public class Stock {
	
	private int id;
	private Dimensione dimTot;
	
	//Creation of shelfs
	Dimensione dim = new Dimensione(20, 3, 3);
	Shelf firstShelf = new Shelf(1500, 0, dim);
	Shelf secondShelf = new Shelf(1000, 1, dim);
	Shelf thirdShelf = new Shelf(1000, 2, dim);
	Shelf fourthShelf = new Shelf(1000, 3, dim);
	private List <Shelf> shelfs = new ArrayList<Shelf>();
	
	public Stock() {
		shelfs.add(firstShelf);
		shelfs.add(secondShelf);
		shelfs.add(thirdShelf);
		shelfs.add(fourthShelf);
		Dimensione placeholder = new Dimensione(dim.getX(), dim.getY()*4, dim.getZ());
		dimTot = placeholder;
		this.id = 0;
	}
	
	public Stock(int id) {
		shelfs.add(firstShelf);
		shelfs.add(secondShelf);
		shelfs.add(thirdShelf);
		shelfs.add(fourthShelf);
		Dimensione placeholder = new Dimensione(dim.getX(), (dim.getY()*4), dim.getZ());
		dimTot = placeholder;
		this.id = id;
	}
	
	public boolean addItem(Item i) {
		for(Shelf shelf : shelfs) {
			if(shelf.fitItem(i)) {
				shelf.addItem(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean fitItem(Item i) throws AdimensionalException {
		for(Shelf shelf : shelfs) {
			if(shelf.fitItem(i)) {
				return true;
			}
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public Dimensione getDimTot() {
		return dimTot;
	}
	
	public List<Shelf> getShelfs(){
		return this.shelfs;
	}

}
