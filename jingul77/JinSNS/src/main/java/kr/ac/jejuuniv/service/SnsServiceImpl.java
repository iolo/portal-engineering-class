package kr.ac.jejuuniv.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jejuuniv.mapper.SnsMapper;
import kr.ac.jejuuniv.model.SnsListModel;
import kr.ac.jejuuniv.model.SnsModel;

@Service
public class SnsServiceImpl implements SnsService {
	
	@Autowired
	SnsMapper snsMapper;
	
	
	@Override
	public List<SnsListModel> personalList(String id) {
		
		return snsMapper.PersonalSns(id);
	}


	@Override
	public void remove(String index) {
		
		snsMapper.remove(Integer.parseInt(index));
	}
	
	@Override
	public String date() {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd",Locale.KOREA);
		Date currentTime = new Date();
		return date.format(currentTime);
	}
	
	@Override
	public SnsModel setWrite(String id, String sns) {
		
		String date=this.date();
		SnsModel Sns=new SnsModel(id,sns,date);
		return Sns;
	}

	@Override
	public void writeSns(String id, String sns) {
		
		snsMapper.write(this.setWrite(id, sns));
	}


	@Override
	public List<SnsListModel> allGetSns(String id) {
		
		return snsMapper.allGetSns(id);
	}


}
