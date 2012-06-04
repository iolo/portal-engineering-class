package kr.ac.jejuuniv.model.ssiggle;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import kr.ac.jejuuniv.mapper.SsiggleMapper;
import kr.ac.jejuuniv.model.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class Ssiggle implements Serializable {
	private static final long serialVersionUID = -2443787233787448441L;

	private long id;
	private String text;
	private Timestamp time;
	private User user;

	@Autowired
	private SsiggleMapper ssiggleMapper;

	public Ssiggle() {
	}

	public Ssiggle(SsiggleMapper ssiggleMapper) {
		this.ssiggleMapper = ssiggleMapper;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserId(String user) {
		this.user = new User().findUserById(user);
	}

	public String getUserId() {
		return user.getId();
	}

	public Ssiggle findSsiggleById(long id) {
		Ssiggle ssiggle = ssiggleMapper.selectSsiggleById(id);
		if (ssiggle == null) {
			throw new NotFoundSsiggleException("요청한 Ssiggle " + id
					+ " (을)를 찾을 수 없습니다.");
		}

		return ssiggle;
	}

	public List<Ssiggle> ssiggleListByUserIdDesTime(String loginId) {
		return ssiggleMapper.selectSsiggleListByUserIdDescTime(loginId);
	}

	public void save() {
		if (findSsiggleById(getId()) == null) {
			ssiggleMapper.updateSsiggle(this);
		} else {
			ssiggleMapper.insertSsiggle(this);
		}
	}

	public void delete() {
		ssiggleMapper.deleteSsiggleById(this.getId());
	}

	@Override
	public String toString() {
		return "Ssiggle [id=" + id + ", text=" + text + ", time=" + time
				+ ", user=" + user + "]";
	}
}