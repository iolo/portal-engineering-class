package kr.ac.jejunu.repositry;

import java.util.List;

import javax.activation.DataSource;

import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.model.IndexList;
import kr.ac.jejunu.model.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class CommentService {

	@Autowired
	private SqlMapper sqlMapper;
	
	@Autowired
	private DataSourceTransactionManager txManager;

	public List<Comment> findAll() {
		return sqlMapper.selectAll();
	}

	public void writeComment(Comment comment) {
		sqlMapper.insertComment(comment);
	}

	private int up(double num) {
		double tmp = num / 10;
		// System.out.println(tmp);
		return (int) (Math.ceil(tmp) * 10);
	}

	public List<Comment> showPageOne(int pageNumber) {
		List<IndexList> indexList = sqlMapper.selectListForIndex();
		int page = (int) Math.ceil(indexList.size() / 10);
		int selectPageLastListId = indexList.size() - pageNumber * 10 + 1;
		if (selectPageLastListId < 0) {
			selectPageLastListId = 0;
		}
		return sqlMapper.selectPageOne(selectPageLastListId);
	}

	public int pageCount() {
		List<IndexList> indexList = sqlMapper.selectListForIndex();
		return (int) Math.ceil((double) indexList.size() / 10);
	}

	public void removeComment(int removeCommentListId) {
		sqlMapper.deleteComment(removeCommentListId);
	}

	public void joinUser(UserInfo user) {
		sqlMapper.insertUser(user);
	}

	public UserInfo findUserInfoById(String userId) {
		return sqlMapper.selectUser(userId);
	}

	public Comment findCommentByListId(int listId) {
		return sqlMapper.selectComment(listId);
	}

	public void addUserLikeComment(String user, int comment, String like) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus status = txManager.getTransaction(def);
		try {
			if(!sqlMapper.selectUserLikeCheck(user, comment)){
				if(like == "po"){
					//±‡¡§
					sqlMapper.updatePositiveUser(comment);
				}else if(like == "ne"){
					//∫Œ¡§
					sqlMapper.updateNegativeUser(comment);
				}
				sqlMapper.insertUserLikeCommentCheck(user, comment);
			}
		} catch (RuntimeException e) {
			txManager.rollback(status);
			throw e;			
		}
		
		txManager.commit(status);
	}
}
