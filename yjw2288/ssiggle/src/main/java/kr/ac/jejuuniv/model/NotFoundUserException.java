package kr.ac.jejuuniv.model;

public class NotFoundUserException extends RuntimeException {
	private static final long serialVersionUID = 4051675531797608945L;

	public NotFoundUserException(String message) {
		super(message);
	}
}
