package kr.ac.jejunu.rabbit.service;

public class DuplicatedUserIdException extends RuntimeException {
	private static final long serialVersionUID = 7347823386830330404L;
	private String errorMsg;
	
	public DuplicatedUserIdException(String id) {
		super();
		errorMsg = id + "의 사용자 존재합니다.";
	}	

	public String getErrorMsg() {
		return errorMsg;
	}
}
