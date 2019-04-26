package xbc.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import xbc.model.BatchTest;

@Repository
public class BatchTestDaoImpl extends AbstractHibernateDao<BatchTest> implements BatchTestDao {

	public BatchTestDaoImpl() {
		setClazz(BatchTest.class);
	}
	
//	public Collection<BatchTest> findAll() {
//		String hql = "FROM BatchTest BT "
//				   + "WHERE BT.isDelete = 'false'";
//		Query q = getCurrentSession().createQuery(hql);
//		Collection<BatchTest> result = q.list();
//		return result;
//	}
//	
//	public Collection<BatchTest> findTestByBatchId(Integer batchId) {
//		String hql = "FROM BatchTest BT "
//				   + "WHERE BT.batchId = :batchId ";
//		Query q = getCurrentSession().createQuery(hql);
//		Collection<BatchTest> result = q.list();
//		return result;
//	}
}
