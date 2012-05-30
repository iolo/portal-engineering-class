package kr.ac.jejuuniv.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Ssiggle implements Serializable {
	private static final long serialVersionUID = -2443787233787448441L;

	private long id;
	private String text;
	private Timestamp time;
	private String user;

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