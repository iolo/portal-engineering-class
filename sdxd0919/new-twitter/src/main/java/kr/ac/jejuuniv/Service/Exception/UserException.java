package kr.ac.jejuuniv.Service.Exception;

public class UserException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UserException() {
		super();
	}

	public UserException(String error_message){
		super(error_message);
	}

}
