package xbc.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import xbc.model.Batch;

@Repository
public class BatchDaoImpl extends AbstractHibernateDao<Batch> implements BatchDao {
	
	public BatchDaoImpl() {
		setClazz(Batch.class);		
	}
	
	public Collection<Batch> search(final String name) {
		String hql = "FROM Batch B "
				   + "WHERE (LOWER(B.name) LIKE LOWER(:name) "
				   + "AND B.isDelete = 'false'";
		Query q = getCurrentSession().createQuery(hql);
		q.setParameter("name", "%" + name + "%");
		Collection<Batch> result = q.list();
		return result;
	}
}
