package kr.ac.jejuuniv.controller.user;

public class NotFollowException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NotFollowException(String message) {
		super(message);
	}
}
