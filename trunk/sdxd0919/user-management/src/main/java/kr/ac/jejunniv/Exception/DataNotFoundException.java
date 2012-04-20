package kr.ac.jejunniv.Exception;

public class DataNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DataNotFoundException(String meg) {
		System.out.println(meg);
	}
}
