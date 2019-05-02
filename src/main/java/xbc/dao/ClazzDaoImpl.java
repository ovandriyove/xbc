package xbc.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xbc.model.Batch;
import xbc.model.Biodata;
import xbc.model.Clazz;

@Repository
public class ClazzDaoImpl extends AbstractHibernateDao<Clazz> implements ClazzDao {

	@Autowired
	private BatchDao batchDao;
	
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
	
	public Collection<Biodata> biodataTersedia(Integer id) {
//		String hql = "SELECT b.periodFrom, b.periodTo "
//				   + "FROM Batch b "
//				   + "WHERE b.id = :id";
//		
//		Query q = getCurrentSession().createQuery(hql);
//		q.setParameter("id", id);
//		Batch batch = (Batch) q.list().get(0);
		Batch batch = batchDao.findOne(id);

		String hql2 = "FROM Biodata bio "
				    + "WHERE bio.isDelete = false AND bio.id NOT IN ( "
				    + "SELECT cl.biodataId "
				    + "FROM Clazz cl "
				    + "WHERE :periodToSekarang > cl.batch.periodFrom AND :periodFromSekarang < cl.batch.periodTo "
				    + "OR :periodToSekarang > cl.batch.periodTo AND :periodFromSekarang < cl.batch.periodFrom)"; 
		Query q2 = getCurrentSession().createQuery(hql2);
		q2.setParameter("periodFromSekarang", batch.getPeriodFrom());
		q2.setParameter("periodToSekarang", batch.getPeriodTo());
		Collection<Biodata> result = q2.list();
		return result;
	}
}		
		
//	SELECT bio.name FROM t_biodata bio
//	WHERE bio.id NOT IN (
//		SELECT cl.biodata_id 
//		FROM t_clazz cl
//		WHERE cl.batch_id IN (
//			SELECT b2.id
//			FROM t_batch b2, 
//				(SELECT b.period_from, b.period_to 
//				 FROM t_batch b 
//				 WHERE b.id = 1) b1
//			WHERE b1.period_to > b2.period_from AND b1.period_from < b2.period_to
//		)
//	)

