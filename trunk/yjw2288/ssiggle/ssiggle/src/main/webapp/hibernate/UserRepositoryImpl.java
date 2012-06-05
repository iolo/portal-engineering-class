package kr.ac.jejuuniv.repository.impl;

import java.util.List;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User selectUserById(String id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public void insertUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectAllUser() {
		return (List<User>) (sessionFactory.getCurrentSession().createQuery(
				"from User").list());
	}
}