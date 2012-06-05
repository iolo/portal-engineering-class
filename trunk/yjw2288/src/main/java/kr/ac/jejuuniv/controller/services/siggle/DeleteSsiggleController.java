package kr.ac.jejuuniv.controller.services.siggle;

import kr.ac.jejuuniv.model.ssiggle.Ssiggle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/service/deleteSsiggle")
public class DeleteSsiggleController {
	@RequestMapping(method=RequestMethod.GET)
	public String action(@RequestParam("userId") String userId,
			@RequestParam("ssiggleId") long ssiggleId) {

		Ssiggle ssiggle = new Ssiggle().findSsiggleById(ssiggleId);
		ssiggle.delete();

		return "redirect:/service/user/" + userId;
	}
}
