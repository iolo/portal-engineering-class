package kr.ac.jejuuniv.service.login;

public class DuplicationLoginException extends RuntimeException {

	private static final long serialVersionUID = 4025139712466371432L;

	public DuplicationLoginException(String message) {
		super(message);
	}
}
