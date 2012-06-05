package kr.ac.jejuuniv.repository;

public class IdExistNotException extends RuntimeException {
	private static final long serialVersionUID = -2744884938710514939L;

	public IdExistNotException(String string) {
		super(string);
	}
}
