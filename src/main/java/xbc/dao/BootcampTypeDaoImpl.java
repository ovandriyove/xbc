package xbc.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import xbc.model.BootcampType;

@Repository
public class BootcampTypeDaoImpl extends AbstractHibernateDao<BootcampType> implements BootcampTypeDao {

	public BootcampTypeDaoImpl() {
		setClazz(BootcampType.class);
	}
	
	public Collection<BootcampType> findAll() {
		String hql = "FROM BootcampType B "
				   + "WHERE B.isDelete = 'false'";
		Query q = getCurrentSession().createQuery(hql);
		Collection<BootcampType> result = q.list();
		return result;
	}
}
