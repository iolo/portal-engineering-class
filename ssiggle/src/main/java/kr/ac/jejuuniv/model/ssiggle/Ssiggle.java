package kr.ac.jejuuniv.model.ssiggle;

import java.sql.Timestamp;
import java.util.List;

import kr.ac.jejuuniv.mapper.SsiggleMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class Ssiggle implements SsiggleTransaction {
	private static final long serialVersionUID = -2443787233787448441L;

	private long id;
	private String text;
	private Timestamp time;
	private String user;

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

	public String getUser() {
		return user;
	}

	public void setUser(String id) {
		this.user = id;
	}

	@Override
	public Ssiggle findSsiggleById(long id) {
		Ssiggle ssiggle = ssiggleMapper.selectSsiggleById(id);
		if (ssiggle == null) {
			throw new NotFoundSsiggleException("요청한 Ssiggle " + id
					+ " (을)를 찾을 수 없습니다.");
		}

		return ssiggle;
	}

	@Override
	public List<Ssiggle> ssiggleListByUserIdDesTime(String loginId) {
		return ssiggleMapper.selectSsiggleListByUserIdDescTime(loginId);
	}

	@Override
	public void save() {
		ssiggleMapper.insertSsiggle(this);
	}

	@Override
	public void delete() {
		ssiggleMapper.deleteSsiggleById(this.getId());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ssiggle other = (Ssiggle) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ssiggle [id=" + id + ", text=" + text + ", time=" + time
				+ ", user=" + user + "]";
	}
}