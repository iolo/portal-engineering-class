package kr.ac.jejuuniv.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.ac.jejuuniv.model.ssiggle.Ssiggle;
import kr.ac.jejuuniv.model.user.User;

@Transactional
public interface SsiggleService {
	@Transactional(readOnly = true)
	public List<Ssiggle> readAllSsiggleByFollowingUser(User user, Ssiggle ssiggle);
}
