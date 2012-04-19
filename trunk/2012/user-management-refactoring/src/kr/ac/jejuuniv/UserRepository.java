package kr.ac.jejuuniv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepository implements IUserRepository{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public UserRepository() {
	}



	/* (non-Javadoc)
	 * @see kr.ac.jejuuniv.IUserRepository#findAll()
	 */
	@Override
	public List<User> findAll() {
		return jdbcTemplate.findAll("select * from userinfo");
	}





	/* (non-Javadoc)
	 * @see kr.ac.jejuuniv.IUserRepository#findAllOrderByIdDesc()
	 */
	@Override
	public List<User> findAllOrderByIdDesc() {
		return jdbcTemplate.findAll("select * from userinfo order by id desc");

	}



}
