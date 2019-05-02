package xbc.dao;

import java.util.Collection;
import java.util.Date;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xbc.model.Batch;
import xbc.model.Biodata;
import xbc.model.Trainer;

@Repository
public class BatchDaoImpl extends AbstractHibernateDao<Batch> implements BatchDao {
	
	public BatchDaoImpl() {
		setClazz(Batch.class);		
	}
	
	public Collection<Batch> search(final String name) {
		String hql = "FROM Batch B "
				   + "WHERE (LOWER(B.name) LIKE LOWER(:name) "
				   + "OR LOWER(B.technology.name) LIKE LOWER(:name)) "
				   + "AND B.isDelete = 'false'";
		Query q = getCurrentSession().createQuery(hql);
		q.setParameter("name", "%" + name + "%");
		Collection<Batch> result = q.list();
		return result;
	}
	
	@Override
	public boolean checkDuplicate(String name, Integer id) {
		String hql  = "SELECT COUNT(*) "
					+ "FROM Batch B "
					+ "WHERE LOWER(B.name) = LOWER(:name) "
					+ "AND B.isDelete = 'false' "
					+ "AND B.id != :idSekarang";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("name", name);
		if (id == null) {
			id = 0;
		}
		query.setParameter("idSekarang", id);
		Long count = (Long) query.list().get(0);
		if (count == 0) {
			return false;	
		} else {
			return true;
		}
	}

	@Override
	public Collection<Trainer> trainerTersedia(Date periodFromSekarang, Date periodToSekarang) {
//		Batch batch = batchDao.findOne(id);
		String hql = "FROM t_trainer tra "
				   + "WHERE tra.isDelete = false AND tra.id NOT IN "
				   + "(SELECT b.id FROM t_batch b "
				   + "WHERE :periodToSekarang > b.periodFrom AND :periodFromSekarang < b.periodTo";
		Query q = getCurrentSession().createQuery(hql);
		q.setParameter("periodFromSekarang", periodFromSekarang);
		q.setParameter("periodToSekarang", periodToSekarang);
		Collection<Trainer> result = q.list();
		return result;
	}
	
//	SELECT tra.name FROM trainer tra
//	WHERE tra.isDelete = false and tra.id NOT IN (
//			SELECT b.tranerId
//			FROM batch b
//			WHERE :periodetoSekarang > b2.periodTo AND :perioidFromSekarang < b.periodFrom)
//		
}
