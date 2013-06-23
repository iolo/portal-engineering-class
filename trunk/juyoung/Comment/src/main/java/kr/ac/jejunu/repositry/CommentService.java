package kr.ac.jejunu.repositry;

import java.util.List;

import kr.ac.jejunu.model.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
	
	@Autowired
	private SqlMapper sqlMapper;

	public List<Comment> findAll() {
		return sqlMapper.selectAll();
	}

	public void writeComment(Comment comment) {
		sqlMapper.insertComment(comment);
	}
}
