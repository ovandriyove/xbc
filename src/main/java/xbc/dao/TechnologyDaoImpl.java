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
	
	public Collection<Technology> search(final String name) {
		String hql = "FROM Technology T "
				   + "WHERE LOWER(T.name) LIKE LOWER(:name) "
				   + "AND T.isDelete = 'false'";
		Query q = getCurrentSession().createQuery(hql);
		q.setParameter("name", "%" + name + "%");
		Collection<Technology> result = q.list();
		return result;
	}
}
