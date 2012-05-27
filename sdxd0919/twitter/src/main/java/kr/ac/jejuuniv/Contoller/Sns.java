package kr.ac.jejuuniv.Contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("**/SNS")
public class Sns {

	@RequestMapping
	public String sns(){
		return "/SNS";
	}
}
