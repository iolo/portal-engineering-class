package kr.ac.jejuuniv.repository.impl;

import java.util.List;

import kr.ac.jejuuniv.model.Ssiggle;
import kr.ac.jejuuniv.repository.SsiggleRepository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SsiggleRepositoryImpl implements SsiggleRepository {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Ssiggle selectSsiggleById(long id) {
		return (Ssiggle) sessionFactory.getCurrentSession().get(Ssiggle.class,
				id);
	}

	@Override
	public void deleteSsiggleById(long id) {
		sessionFactory.getCurrentSession().delete(selectSsiggleById(id));
	}

	@Override
	public void insertSslggle(Ssiggle s) {
		sessionFactory.getCurrentSession().save(s);
	}

	@Override
	public void updateSsiggle(Ssiggle s) {
		sessionFactory.getCurrentSession().update(s);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ssiggle> selectSsiggleListByUserIdDescTime(String userId) {
		return (List<Ssiggle>) sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Ssiggle where user = :user order by time desc")
				.setString("user", userId).list();
	}
}