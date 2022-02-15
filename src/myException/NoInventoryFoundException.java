package myException;

public class NoInventoryFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public NoInventoryFoundException(String message) {
		super(message);
	}
	
}
