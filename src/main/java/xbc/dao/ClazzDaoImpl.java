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
		Batch batch = batchDao.findOne(id);

		String hql2 = "FROM Biodata bio "
				    + "WHERE bio.isDelete = false AND bio.id NOT IN ( "
				    + "SELECT cl.biodataId "
				    + "FROM Clazz cl "
				    + "WHERE :periodToSekarang > cl.batch.periodFrom AND :periodFromSekarang < cl.batch.periodTo"; 
		Query q2 = getCurrentSession().createQuery(hql2);
		q2.setParameter("periodFromSekarang", batch.getPeriodFrom());
		q2.setParameter("periodToSekarang", batch.getPeriodTo());
		Collection<Biodata> result = q2.list();
		return result;
	}
}		
