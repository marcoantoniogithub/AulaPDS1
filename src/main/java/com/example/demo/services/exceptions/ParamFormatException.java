package com.example.demo.services.exceptions;

public class ParamFormatException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ParamFormatException(String msg) {
		super(msg);
	}
}
