package kr.ac.jejunu.rabbit.service;

public class UserAlreadyDeleteException extends RuntimeException {
	private static final long serialVersionUID = -7820524637187278293L;
	private String errorMsg;
	
	public UserAlreadyDeleteException(String id) {
		super();
		errorMsg = id + "는 이미 삭제되었습니다.";
	}	

	public String getErrorMsg() {
		return errorMsg;
	}
}
