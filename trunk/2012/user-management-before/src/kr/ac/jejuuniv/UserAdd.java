package kr.ac.jejuuniv;


public class UserAdd {
	
	public static void main(String args[]) {
		User user= new User();
		user.setId("777");
		user.setName("나이름");
		user.setPassword("12345");
		user.add();
		User user2 = user.get("777");
		System.out.println("id : " + user2.getId());
		System.out.println("name : " + user2.getName());
		System.out.println("password : " + user2.getPassword());
	}
}
