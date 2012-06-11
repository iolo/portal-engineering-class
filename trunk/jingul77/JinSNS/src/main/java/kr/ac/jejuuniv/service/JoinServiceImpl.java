package kr.ac.jejuuniv.service;

import kr.ac.jejuuniv.mapper.JoinMapper;
import kr.ac.jejuuniv.model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinServiceImpl implements JoinService {
	
	@Autowired
	JoinMapper joinMapper;
	
	@Override
	public void joinUser(String id, String password, String name, String explain,String image){
		UserModel user=new UserModel(id, password, name, explain, image);
		joinMapper.joinUser(user);		
	}
}
