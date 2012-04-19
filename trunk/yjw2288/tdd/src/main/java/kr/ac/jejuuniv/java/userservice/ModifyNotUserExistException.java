package kr.ac.jejuuniv.java.userservice;

public class ModifyNotUserExistException extends RuntimeException {
	private static final long serialVersionUID = 5406854697401940910L;

	public ModifyNotUserExistException() {
	}

	public ModifyNotUserExistException(String message) {
		super(message);
	}
}
