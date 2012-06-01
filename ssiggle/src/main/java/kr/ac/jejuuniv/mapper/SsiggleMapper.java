package kr.ac.jejuuniv.mapper;

import java.util.List;

import kr.ac.jejuuniv.model.ssiggle.Ssiggle;
import kr.ac.jejuuniv.model.ssiggle.SsiggleTransaction;

public interface SsiggleMapper {
	Ssiggle selectSsiggleById(long id);

	void deleteSsiggleById(long id);

	void insertSsiggle(SsiggleTransaction s);

	void updateSsiggle(SsiggleTransaction s);

	List<Ssiggle> selectSsiggleListByUserIdDescTime(String userId);
}
