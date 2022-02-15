package utility;

import java.util.ArrayList;
import java.util.List;

public class OperationList {

	List<String> operation = new ArrayList<String>();
	
	public OperationList() {
		operation.add("Get info");
		operation.add("operation 0: Exit");
		operation.add("operation 1: Add item to Stock");
		operation.add("operation 2: Add stock to inventory");
		operation.add("operation 3: Get all product for an inventory");
		operation.add("operation 4: Get the list of inventories");
		operation.add("operation 5: Get the list of stocks in one inventory");
		operation.add("operation 6: Get all items");
		operation.add("operation 7: Add new inventory");
	}
	
	public ArrayList<String> getOperations(){
		return (ArrayList<String>) this.operation;
	}
}
