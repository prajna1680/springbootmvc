package com.stackroute.restaurantspringboot.exceptions;

public class DataBaseNotAvailableException extends Exception {

	public DataBaseNotAvailableException() {
		super();
}
	
	public DataBaseNotAvailableException(String message) {
		super(message);
}

}
