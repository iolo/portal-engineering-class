package kr.ac.jejuuniv;

import java.util.List;

public interface UserService {

	List<User> list();

	User getUserList(String string);

	User addUser(User user);

	User deleteUserList(String string);

}
