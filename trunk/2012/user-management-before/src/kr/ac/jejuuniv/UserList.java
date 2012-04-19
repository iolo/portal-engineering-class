package kr.ac.jejuuniv;

import java.util.List;

public class UserList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User user= new User();
		List<User> users = user.list();
		for(User resultUser : users) {
			System.out.println("id : " + resultUser.getId());
			System.out.println("name : " + resultUser.getName());
			System.out.println("password : " + resultUser.getPassword());
		}
	}

}
