package kr.ac.jejuuniv.controller.ssiggle;

import kr.ac.jejuuniv.model.ssiggle.Ssiggle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/service/writeSsiggle")
public class WriteSsiggleController {
	@RequestMapping(method=RequestMethod.GET)
	public String action(@RequestParam("userId") String userId, ModelMap model) {
		Ssiggle ssiggle = new Ssiggle();
		ssiggle.setUser(userId);
		model.addAttribute("ssiggle", ssiggle);

		return "writeSsiggle";
	}
}
