package myException;

public class NoStockIdFound extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoStockIdFound(String message) {
		super(message);
	}
	
}
