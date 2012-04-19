package kr.ac.jejuuniv.java.userservice;

public class ModifyNotException extends RuntimeException {
	private static final long serialVersionUID = 5406854697401940910L;

	public ModifyNotException() {
	}

	public ModifyNotException(String message) {
		super(message);
	}
}
