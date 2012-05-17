package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.mapper.UserMapper;
import kr.ac.jejuuniv.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private DataSourceTransactionManager txManager;
	
	public UserService() {
	}
	
	public List<User> getList() {
		List<User> users = userMapper.findAll();
		return users;
	}
	
	public List<User> getListOrderByIdDesc() {
		List<User> users = userMapper.findAllOrderByIdDesc();
		return users;
	}

	public void addUser(User user) {
		userMapper.addUser(user);
	}

	public void deleteAndAddUser(String deleteUserId, User user, boolean throwException) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		TransactionStatus status = txManager.getTransaction(def);
		try {
			
			userMapper.deleteUser(deleteUserId);
			if (throwException) {
				throw new RuntimeException("Unknown error.");
			}
			userMapper.addUser(user);

		}
		catch (RuntimeException ex) {
		  txManager.rollback(status);
		  throw ex;
		}
		txManager.commit(status);
	}

}
