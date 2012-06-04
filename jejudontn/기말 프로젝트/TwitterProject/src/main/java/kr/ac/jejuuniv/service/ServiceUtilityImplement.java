package kr.ac.jejuuniv.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service
public class ServiceUtilityImplement implements ServiceUtility {

	@Override
	public String getTime() {		
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy.MM.dd", Locale.KOREA );
		Date currentTime = new Date ( );
		return mSimpleDateFormat.format ( currentTime );
	}

}
