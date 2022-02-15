package utility;

import java.util.Scanner;

public class Dimensione {

	private double x;
	private double y;
	private double z;
	
	public Dimensione() {}
	
	public Dimensione(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	@Override
	public String toString() {
		return "Dimensione [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
	public boolean isValorized() {
		if(this.x > 0 && this.y > 0 && this.z > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void setDimensione() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci la larghezza (x)");
		String toX = sc.nextLine();
		this.x = Double.parseDouble(toX);
		System.out.println("Inserisci l'altezza (y)");
		String toY = sc.nextLine();
		this.y = Double.parseDouble(toY);
		System.out.println("Inserisci la profondità (z)");
		String toZ = sc.nextLine();
		this.z = Double.parseDouble(toZ);
		sc.close();
	}
	
}
