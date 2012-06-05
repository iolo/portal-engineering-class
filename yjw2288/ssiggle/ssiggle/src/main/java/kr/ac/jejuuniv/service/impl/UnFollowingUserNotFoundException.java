package kr.ac.jejuuniv.service.impl;

public class UnFollowingUserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7175585578635805440L;

	public UnFollowingUserNotFoundException(String message) {
		super(message);
	}
}
