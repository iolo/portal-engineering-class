package kr.ac.jejuuniv.service.login;

public class NotLoginUserException extends RuntimeException {
	private static final long serialVersionUID = 671027776922135090L;

	public NotLoginUserException(String message) {
		super(message);
	}
}
