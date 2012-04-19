package kr.ac.jejuuniv.java.userservice;

public class UserEmptyException extends RuntimeException {

	private static final long serialVersionUID = -279246733062900375L;

	public UserEmptyException() {
		super();
	}

	public UserEmptyException(String message) {
		super(message);
	}

}