package kr.ac.jejuuniv.repository;

import java.util.List;

import kr.ac.jejuuniv.model.User;

public interface IUserRepository {

	public abstract List<User> findAll();

	public abstract List<User> findAllOrderByIdDesc();

}