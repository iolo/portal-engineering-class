package kr.ac.jejuuniv.model.ssiggle;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SsiggleTransaction extends Serializable {

	@Transactional(readOnly = true)
	public List<Ssiggle> ssiggleListByUserIdDesTime(String loginId);

	@Transactional
	public void save();

	@Transactional
	public void delete();

	@Transactional
	public Ssiggle findSsiggleById(long id);
}
