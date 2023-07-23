package com.restapi.utilities;

public class RecordNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String message;
	public RecordNotFoundException(Integer sno) {
		message = "No Person found with sno  "+sno;
	}
	public String toString() {
		return message;
	}
}
