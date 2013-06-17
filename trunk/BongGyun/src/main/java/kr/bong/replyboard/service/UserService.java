package kr.bong.replyboard.service;

import kr.bong.replyboard.model.User;

public interface UserService {
	int join(User user);
	
	int modify(User user);
	
	User getUser(String id);
	
	/** null이면 로그인 실패 아니면 해당하는 사용자 정보 */
	User loginCheck(String id, String password);
}
