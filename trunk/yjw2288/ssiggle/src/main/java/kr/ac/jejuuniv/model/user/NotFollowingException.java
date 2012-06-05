package kr.ac.jejuuniv.model.user;

public class NotFollowingException extends RuntimeException {
	private static final long serialVersionUID = 3677085728575901957L;

	public NotFollowingException(String message) {
		super(message);
	}
}
