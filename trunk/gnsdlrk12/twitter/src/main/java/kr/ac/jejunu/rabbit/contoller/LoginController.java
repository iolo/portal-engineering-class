package kr.ac.jejunu.rabbit.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.ac.jejunu.rabbit.mapper.UserMapper;
import kr.ac.jejunu.rabbit.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
@RequestMapping("/login")
public class LoginController {
	
    @Autowired
	UserMapper usermapper;
    
    // 로그인 처리
    @RequestMapping(value="loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(User user, HttpSession session, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/");
 
        User loginUser = usermapper.Check(user);
 
        if (loginUser != null) {
            session.setAttribute("userLoginInfo", loginUser);
        }
        return mav;
    }
}