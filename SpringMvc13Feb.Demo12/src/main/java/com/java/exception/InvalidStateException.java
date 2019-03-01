package com.java.exception;

public class InvalidStateException extends RuntimeException {

	private static final long serialVersionUID = 1173885534932797192L;

	public InvalidStateException(String message) {
		super(message);
	}
}
