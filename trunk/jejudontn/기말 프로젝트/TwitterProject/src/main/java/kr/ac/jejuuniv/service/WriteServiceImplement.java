package kr.ac.jejuuniv.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import kr.ac.jejuuniv.model.Twitt;
import kr.ac.jejuuniv.repository.TwiitMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriteServiceImplement implements WriteService {
	
	@Autowired
	TwiitMapper twiitMapper;
	
	
	@Override
	public void createTwiit(String id, String twiit) {
		String twiitId = "id" + System.currentTimeMillis();
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy.MM.dd", Locale.KOREA );
		Date currentTime = new Date ( );
		String mTime = mSimpleDateFormat.format ( currentTime );
		Twitt maketwiit = new Twitt();
		maketwiit.setId(id);
		maketwiit.setTwiitt(twiit);
		maketwiit.setWritrDate(mTime);
		maketwiit.setTwiitID(twiitId);
		
		twiitMapper.createTwiit(maketwiit);
		
		
	}

}
