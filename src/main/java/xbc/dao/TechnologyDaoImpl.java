package xbc.dao;

import org.springframework.stereotype.Repository;

import xbc.model.Technology;

@Repository
public class TechnologyDaoImpl extends AbstractHibernateDao<Technology> implements TechnologyDao {

	public TechnologyDaoImpl() {
		setClazz(Technology.class);
	}
}
