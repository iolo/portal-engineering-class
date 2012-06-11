package kr.ac.jejuuniv.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.jejuuniv.model.SnsListModel;
import kr.ac.jejuuniv.model.SnsModel;

@Repository
public interface SnsMapper {
	
	List<SnsListModel> PersonalSns(String id);

	void remove(int index);

	void write(SnsModel setWrite);

}
