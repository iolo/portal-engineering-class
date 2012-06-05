package kr.ac.jejuuniv.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.ac.jejuuniv.model.Ssiggle;

@Transactional
public interface SsiggleRepository {

	@Transactional(readOnly = true)
	Ssiggle selectSsiggleById(long id);

	@Transactional
	void deleteSsiggleById(long id);

	@Transactional
	void insertSslggle(Ssiggle s);

	@Transactional
	void updateSsiggle(Ssiggle s);

	@Transactional(readOnly = true)
	List<Ssiggle> selectSsiggleListByUserIdDescTime(String userId);
}
