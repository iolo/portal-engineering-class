package kr.ac.jejuuniv;

public class UserNotFoundExcpetion extends RuntimeException {
	String userId;
	public UserNotFoundExcpetion(String newUserId) {
		userId = newUserId;
	}

	private static final long serialVersionUID = 7825366261104625621L;

}
