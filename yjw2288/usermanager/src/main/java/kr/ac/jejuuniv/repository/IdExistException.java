package kr.ac.jejuuniv.repository;

public class IdExistException extends RuntimeException {
	private static final long serialVersionUID = -2744884938710514939L;

	public IdExistException(String string) {
		super(string);
	}
}
