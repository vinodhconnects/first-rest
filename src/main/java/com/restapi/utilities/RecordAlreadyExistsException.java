package com.restapi.utilities;

public class RecordAlreadyExistsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	public RecordAlreadyExistsException(Integer sno) {
		message = sno + " is an already existing Person";
	}
	public String toString() {
		return message;
	}

}
