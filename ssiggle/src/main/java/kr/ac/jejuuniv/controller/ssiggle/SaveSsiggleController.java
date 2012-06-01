package kr.ac.jejuuniv.controller.ssiggle;

import kr.ac.jejuuniv.model.ssiggle.Ssiggle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service/saveSsiggle")
public class SaveSsiggleController {
	@RequestMapping
	public String action(@ModelAttribute Ssiggle ssiggle) {
		ssiggle.save();
		return "completeSave";
	}
}
