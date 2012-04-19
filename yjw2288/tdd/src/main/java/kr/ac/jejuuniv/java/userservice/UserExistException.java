package kr.ac.jejuuniv.java.userservice;

public class UserExistException extends RuntimeException {
	public UserExistException(String message) {
		super(message);
	}

	private static final long serialVersionUID = -3042576692899070186L;

}
