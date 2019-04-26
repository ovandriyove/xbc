package xbc.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import xbc.model.Clazz;

@Repository
public class ClazzDaoImpl extends AbstractHibernateDao<Clazz> implements ClazzDao {

	public ClazzDaoImpl() {
		setClazz(Clazz.class);		
	}
	
	public Collection<Clazz> search(final String name) {
		String hql = "FROM Clazz C "
				   + "WHERE (LOWER(C.batch.name) LIKE LOWER(:name) "
				   + "OR LOWER(C.batch.technology.name) LIKE LOWER(:name))";
		Query q = getCurrentSession().createQuery(hql);
		q.setParameter("name", "%" + name + "%");
		Collection<Clazz> result = q.list();
		return result;
	}
}
