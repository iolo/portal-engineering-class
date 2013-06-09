package kr.ac.jejunu.repositry;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.ac.jejunu.model.comment;

public class CommentDaoImp implements CommentDao{
	
	//@Autowired
	//private SqlMapper mapper;

	@Override
	public List<comment> getList() {
		return null;//mapper.getList();
	}

}
