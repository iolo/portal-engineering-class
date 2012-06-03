package kr.ac.jejuuniv.mapper;

import java.util.List;

import kr.ac.jejuuniv.model.Ssiggle;

public interface SsiggleMapper {
	Ssiggle selectSsiggleById(long id);

	void deleteSsiggleById(long id);

	void insertSsiggle(Ssiggle s);

	void updateSsiggle(Ssiggle s);

	List<Ssiggle> selectSsiggleListByUserIdDescTime(String userId);
}