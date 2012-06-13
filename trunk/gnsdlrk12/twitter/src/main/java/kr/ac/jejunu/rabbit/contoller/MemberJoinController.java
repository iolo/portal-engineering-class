package kr.ac.jejunu.rabbit.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/join")
public class MemberJoinController {
	@RequestMapping
	public String memberjoin(){		
		return "memberJoin";
	}
}
