package kr.ac.jejunu.rabbit.service;

public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 7347823386830330404L;
	private String errorMsg;
	
	public UserNotFoundException(String id) {
		super();
		errorMsg = id + "를 찾을수 없습니다.";
	}	

	public String getErrorMsg() {
		return errorMsg;
	}
}
