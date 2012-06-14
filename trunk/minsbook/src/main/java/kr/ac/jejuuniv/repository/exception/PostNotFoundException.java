package kr.ac.jejuuniv.repository.exception;

public class PostNotFoundException extends RuntimeException {
	
	private final String userId;

	public PostNotFoundException(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}
	
	public String getMessage() {
		return userId + "가 작성한 글은 없습니다";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4425385356259694641L;

}
