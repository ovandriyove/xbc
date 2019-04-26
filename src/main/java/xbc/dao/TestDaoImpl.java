	package xbc.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import xbc.model.Test;

@Repository
public class TestDaoImpl extends AbstractHibernateDao<Test> implements TestDao {
	
	public TestDaoImpl() {
		setClazz(Test.class);
	}

	public Collection<Test> findAll() {
		String hql = "FROM Test T "
				   + "WHERE T.isBootcampTest = 'true' "
				   + "AND T.isDelete = 'false'";
		Query q = getCurrentSession().createQuery(hql);
		Collection<Test> result = q.list();
		return result;
	}
	
}
