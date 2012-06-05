package kr.ac.jejuuniv.controller.domainstudy;

import org.springframework.stereotype.Component;

@Component
public class StudyImpl implements Study {
	@Override
	public String getName() {
		return "잘된다.";
	}

}
