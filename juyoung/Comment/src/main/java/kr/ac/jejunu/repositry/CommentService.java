package kr.ac.jejunu.repositry;

import java.util.List;

import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.model.IndexList;

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
	
	private int up(double num) {
		double tmp = num / 10;
		//System.out.println(tmp);
		return (int) (Math.ceil(tmp) * 10);
	}

	public List<Comment> showPageOne(int pageNumber) {
		List<IndexList> indexList = sqlMapper.selectListForIndex();
		int page = (int) Math.ceil(indexList.size() / 10);
		int selectPageLastListId = indexList.size() - pageNumber * 10+1;
		if(selectPageLastListId < 0){
			selectPageLastListId = 0;
		}
		return sqlMapper.selectPageOne(selectPageLastListId);
	}

	public int pageCount() {
		List<IndexList> indexList = sqlMapper.selectListForIndex();
		return (int) Math.ceil((double)indexList.size() / 10);
	}
}
