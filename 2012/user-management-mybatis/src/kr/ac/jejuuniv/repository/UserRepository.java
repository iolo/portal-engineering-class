package kr.ac.jejuuniv.repository;

import java.util.List;

import kr.ac.jejuuniv.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepository implements IUserRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public UserRepository() {
	}

	public List<User> findAll() {
		return jdbcTemplate.findAll("select * from userinfo");
	}

	public List<User> findAllOrderByIdDesc() {
		return jdbcTemplate.findAll("select * from userinfo order by id desc");
	}

}
