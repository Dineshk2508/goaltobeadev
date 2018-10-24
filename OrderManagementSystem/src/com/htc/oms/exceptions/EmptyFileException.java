package com.htc.oms.exceptions;

public class EmptyFileException extends Exception {

	private String errorMessage = "The file is Empty...!";

	public EmptyFileException() {
		super();

	}

	public EmptyFileException(String errorMessage) {

		this.errorMessage = errorMessage;
	}

	@Override
	public String getMessage() {

		return this.errorMessage;
	}

}
