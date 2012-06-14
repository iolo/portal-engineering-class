package kr.ac.jejuuniv.repository.exception;

public class UserNotFoundException extends RuntimeException {

	private final String id;

	public UserNotFoundException(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	private static final long serialVersionUID = -7732580645193234099L;

}
