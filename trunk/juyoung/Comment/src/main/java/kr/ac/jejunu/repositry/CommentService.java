package kr.ac.jejunu.repositry;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.activation.DataSource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.model.IndexList;
import kr.ac.jejunu.model.UserInfo;

import org.apache.ibatis.binding.BindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.multipart.MultipartFile;

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
			try {
				if (sqlMapper.selectUserLikeCheck(user, comment) != false) {
					if (like == "po") {
						sqlMapper.updatePositiveUser(comment);
					} else if (like == "ne") {
						sqlMapper.updateNegativeUser(comment);
					}
					sqlMapper.insertUserLikeCommentCheck(user, comment);
				}
			} catch (BindingException e) {
				
			}
		} catch (RuntimeException e) {
			txManager.rollback(status);
			throw e;
		}

		txManager.commit(status);
	}

	public HttpEntity<byte[]> getImage(HttpServletRequest request) {
		String getImageId = request.getParameter("id");
		String path = "D:/tmpImage/" + getImageId + ".jpg";
		File file = new File(path);
		try {
			BufferedImage image = ImageIO.read(file);
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			ImageIO.write(image, "jpg", output);
			output.flush();
			byte[] imagebyte = output.toByteArray();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_JPEG);
			headers.setContentLength(imagebyte.length);
			return new HttpEntity<byte[]>(imagebyte, headers);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public UserInfo isProfile_urlUploadAndUserInfoAdd(MultipartFile file,
			UserInfo user) {
		Random random = new Random();
		String fileName = String.valueOf(random.nextInt(1000));
		File url = new File("D:/tmpImage/" + fileName + ".jpg");
		try {
			file.transferTo(url);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		user.setProflie_url("http://localhost:8080/jejunu/image?id=" + fileName);
		return user;
	}

	public boolean checkLogin(String id, String password) {
		boolean result = true;
		try {
			result = sqlMapper.selectLoginCheck(id, password);
		} catch (BindingException e) {
			return true;
		}
		return result;
	}
}
