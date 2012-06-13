package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.SnsListModel;
import kr.ac.jejuuniv.model.SnsModel;
import kr.ac.jejuuniv.model.TotalUserModel;

public interface SnsService {
	
	List<SnsListModel> personalList(String id);

	void remove(String id);

	void writeSns(String id, String sns);
	
	SnsModel setWrite(String id,String sns);
	
	String date();

	List<SnsListModel> allGetSns(String id);

	List<TotalUserModel> totalUser(String id);
}
