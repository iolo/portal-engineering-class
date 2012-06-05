package kr.ac.jejuuniv.java.userservice;

public class UserNotRemoveException extends RuntimeException {

	private static final long serialVersionUID = 3875549268029597166L;

	public UserNotRemoveException() {
	}

	public UserNotRemoveException(String message) {
		super(message);
	}
}
