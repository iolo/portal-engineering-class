package kr.ac.jejuuniv.mapper;

import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.ac.jejuuniv.model.UserModel;

@Repository
public interface LoginMapper {
	UserModel findById(Map<String, String> loginMap);
}
