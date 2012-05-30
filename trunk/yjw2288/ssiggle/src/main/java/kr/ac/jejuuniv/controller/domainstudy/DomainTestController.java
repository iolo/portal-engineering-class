package kr.ac.jejuuniv.controller.domainstudy;

import kr.ac.jejuuniv.model.UserImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/domain")
public class DomainTestController {
	@RequestMapping
	public String action(ModelMap model) {
		model.addAttribute("user", new UserImpl().findUser("sens", null));
		return "domainTest";
	}
}