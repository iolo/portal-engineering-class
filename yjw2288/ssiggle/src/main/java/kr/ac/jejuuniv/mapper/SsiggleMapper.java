package kr.ac.jejuuniv.mapper;

import java.util.List;

import kr.ac.jejuuniv.model.ssiggle.Ssiggle;

public interface SsiggleMapper {
	Ssiggle selectSsiggleById(long id);

	void deleteSsiggleById(long id);

	void insertSsiggle(Ssiggle s);

	List<Ssiggle> selectSsiggleListByUserIdDescTime(String userId);
}