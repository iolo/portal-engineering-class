package kr.ac.jejuuniv.service;

public class UserExistException extends RuntimeException {
	public UserExistException(String message) {
		super(message);
	}

	private static final long serialVersionUID = -3042576692899070186L;

}
