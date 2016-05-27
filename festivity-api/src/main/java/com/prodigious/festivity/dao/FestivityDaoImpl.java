package com.prodigious.festivity.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prodigious.festivity.entity.Festivity;

/**
 * @author Daniel Bernal Bazzani
 * @version 0.0.1
 * @since 0.0.1
 *
 *        Implementation of the {@link IFestivityDao}
 */
@Repository
public class FestivityDaoImpl implements IFestivityDao {

	/** Session factory to communicate with the DBMS */
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.prodigious.festivity.dao.FestivityDao#getAllFestivities()
	 */
	@SuppressWarnings("unchecked")
	public List<Festivity> getAllFestivities() {

		List<Festivity> list = sessionFactory.getCurrentSession()
				.createQuery("from Festivity").list();
		System.out.println(list);

		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prodigious.festivity.dao.FestivityDao#saveFestivity(com.prodigious
	 * .festivity.form.Festivity)
	 */
	@Override
	public Festivity saveFestivity(Festivity festivity) {

		festivity.setId(UUID.randomUUID().toString());
		sessionFactory.getCurrentSession().save(festivity);
		return (Festivity) sessionFactory.getCurrentSession().get(
				Festivity.class, festivity.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prodigious.festivity.dao.FestivityDao#updateFestivity(com.prodigious
	 * .festivity.form.Festivity)
	 */
	@Override
	public Festivity updateFestivity(Festivity festivity) {

		sessionFactory.getCurrentSession().update(festivity);
		return (Festivity) sessionFactory.getCurrentSession().get(
				Festivity.class, festivity.getId());
	}

}
