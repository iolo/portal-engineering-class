package kr.ac.jejuuniv.repository;

import kr.ac.jejuuniv.model.Twitt;

import org.springframework.stereotype.Repository;

@Repository
public interface TwiitMapper {

	
	void createTwiit(Twitt maketwiit);

}
