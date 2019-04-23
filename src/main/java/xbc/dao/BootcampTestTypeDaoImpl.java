package xbc.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import xbc.model.BootcampTestType;

@Repository
public class BootcampTestTypeDaoImpl extends AbstractHibernateDao<BootcampTestType> implements BootcampTestTypeDao {

	public BootcampTestTypeDaoImpl() {
		setClazz(BootcampTestType.class);
	}
	
	public Collection<BootcampTestType> findAll() {
		String hql = "FROM BootcampTestType B "
				   + "WHERE B.isDelete = 'false'";
		Query q = getCurrentSession().createQuery(hql);
		Collection<BootcampTestType> result = q.list();
		return result;
	}
}
