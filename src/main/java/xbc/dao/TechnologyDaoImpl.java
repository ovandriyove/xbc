package xbc.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import xbc.model.Technology;

@Repository
public class TechnologyDaoImpl extends AbstractHibernateDao<Technology> implements TechnologyDao {

	public TechnologyDaoImpl() {
		setClazz(Technology.class);
	}
	
	public Collection<Technology> findAll() {
		String hql = "FROM Technology T "
				   + "WHERE T.isDelete = 'false'";
		Query q = getCurrentSession().createQuery(hql);
		Collection<Technology> result = q.list();
		return result;
	}
}
