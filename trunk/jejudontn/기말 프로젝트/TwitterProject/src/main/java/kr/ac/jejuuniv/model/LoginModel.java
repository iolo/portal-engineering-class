package kr.ac.jejuuniv.model;

public class LoginModel {
	
	private static String id;
	private static String password;

	public LoginModel(String id, String password) {
		this.setId(id);
		this.setPassword(password);
	}
	
	public LoginModel(){}

	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		LoginModel.id = id;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		LoginModel.password = password;
	}

}
