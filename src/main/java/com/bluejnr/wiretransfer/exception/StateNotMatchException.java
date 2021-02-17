package com.bluejnr.wiretransfer.exception;

public class StateNotMatchException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StateNotMatchException(String message) {
		super(message);
	}
}
