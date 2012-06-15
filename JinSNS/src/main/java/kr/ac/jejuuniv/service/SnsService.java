package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.SnsListModel;
import kr.ac.jejuuniv.model.SnsModel;

public interface SnsService {
	
	List<SnsListModel> personalList(String id);

	void remove(String id);

	void writeSns(String id, String sns);
	
	SnsModel setWrite(String id,String sns);
	
	String date();

	List<SnsListModel> allGetSns(String id);


}
