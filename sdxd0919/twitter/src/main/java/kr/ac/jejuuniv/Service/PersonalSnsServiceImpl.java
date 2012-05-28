package kr.ac.jejuuniv.Service;

import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Repository.PersonalSnsRepository;

public class PersonalSnsServiceImpl implements PersonalSnsUserService {

	private PersonalSnsRepository personalSnsRepository;

	public PersonalSnsServiceImpl() {
	}
	
	public PersonalSnsServiceImpl(PersonalSnsRepository personalSnsRepository) {
		this.personalSnsRepository = personalSnsRepository;
	}

	public User getUser(int userNum) {
		return personalSnsRepository.findByUserNum(userNum);
	}

}
