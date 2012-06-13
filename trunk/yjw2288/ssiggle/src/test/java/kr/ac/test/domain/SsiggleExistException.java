package kr.ac.test.domain;

public class SsiggleExistException extends RuntimeException {
	private static final long serialVersionUID = 7646423132518937363L;

	public SsiggleExistException(String message) {
		super(message);
	}
}
