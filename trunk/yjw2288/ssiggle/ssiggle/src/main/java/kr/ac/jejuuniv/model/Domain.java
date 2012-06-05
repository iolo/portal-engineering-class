package kr.ac.jejuuniv.model;

import java.io.Serializable;

import kr.ac.jejuuniv.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

//이건 잘 되는데 왜 User가 안될까? AspectJ 하고 하이버네이트하고 서로 버그가 있는가?
@Configurable
public class Domain implements Serializable {
	private static final long serialVersionUID = 6602555397347887475L;
	@Autowired
	private UserMapper userMapper;

	public User findUserById(String id) {
		return userMapper.selectUserById(id);
	}
}
