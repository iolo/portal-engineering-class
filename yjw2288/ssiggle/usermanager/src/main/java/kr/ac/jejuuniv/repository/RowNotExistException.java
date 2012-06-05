package kr.ac.jejuuniv.repository;

public class RowNotExistException extends RuntimeException {
	public RowNotExistException(String msg) {
		super(msg);
	}

	private static final long serialVersionUID = 1152994660891088934L;

}
