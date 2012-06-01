package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.user.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

//TODO : 다음에 해야할 일, 팔로잉 관련 업무, 팔로잉, 팔로워 보기, 팔로잉, 언팔로잉, 팔로잉 한 사람들에게서 Ssiggle 을 얻어오는 것, 사용자 중에서 팔로잉 하는 사람 알아내는 방법 
//TODO : 컨트롤러에서 컨트롤러 이동 --> redirect 쓰는거 맞는가?
//TODO : 자바에서의 암호화 기법
//TODO : 뷰에서 보이는 부분 처리는 어디서? 도메인? 아니면 저장? 아니면 새로운 객체? 우선 도메인 측에서 처리, ex) 시간 처리, \n 
//TODO : view 에 쳐져있는 노란색 줄 보기 싫어. 고칠 방법 없는가..
//TODO : allUser.jsp, writeSsiggle 등의 경우에서 get으로 값 넘기는게 좋은가, 아니면 컨트롤러에서 쿠키값 받아오는게 좋은가..
//TODO : 팔로잉 하는 사람들한테서 Ssiggle을 얻어오는거 어느 도메인 관련된 업무일까? Ssiggle ?? User?? 아니면 새로운 도메인을 만들어야 하는 걸까?
//TODO : SQL 방식의 로직 처리, 친구는 이것이 성능이 좋다고 함, 하지만 토비에서는 성능상의 문제가 있다고 함. 어느 말이 맞는걸까?
@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping
	public String action(
			@CookieValue(value = "loginId", required = false) String loginId,
			ModelMap model) {
		if (loginId == null || loginId.equals("")) {
			return "login";
		}

		User user = new User().findUserById(loginId);

		model.addAttribute("user", user);
		//TODO : 나중에 팔로워들의 Ssiggle을 읽는 코드로 변환
		model.addAttribute("allUser", user.findAllUser());
		return "main";
	}
}