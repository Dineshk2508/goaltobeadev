package com.htc.corejava.exception;

public class ComputerNotFoundException extends Exception {
	private String errorMessage = "Computer not found in DB...!";

	public ComputerNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComputerNotFoundException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	@Override
	public String getMessage() {

		return this.errorMessage;
	}

}
