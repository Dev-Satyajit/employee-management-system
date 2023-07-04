package com.satyajit.employeemanagementsystem.exception;

public class DataNotFoundException extends RuntimeException {

	static final long serialVersionUID = 1L;

	public DataNotFoundException() {
		super();
	}

	public DataNotFoundException(String message) {
		super(message);
	}

}
