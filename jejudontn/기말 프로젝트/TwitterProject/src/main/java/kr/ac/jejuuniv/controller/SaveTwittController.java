package kr.ac.jejuuniv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/savetwitt")
public class SaveTwittController {
	

	@RequestMapping(method = RequestMethod.POST)
	public void saveTwitt(String id, @RequestParam("twitt") String twitt){

	}

}
