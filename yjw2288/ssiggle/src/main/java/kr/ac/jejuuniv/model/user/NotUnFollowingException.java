package kr.ac.jejuuniv.model.user;

public class NotUnFollowingException extends RuntimeException {
	private static final long serialVersionUID = -8542512845387495376L;

	public NotUnFollowingException(String message) {
		super(message);
	}
}
