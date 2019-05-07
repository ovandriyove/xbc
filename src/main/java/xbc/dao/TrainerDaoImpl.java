package xbc.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import xbc.model.Trainer;

@Repository
public class TrainerDaoImpl extends AbstractHibernateDao<Trainer> implements TrainerDao {

	public TrainerDaoImpl () {
		setClazz(Trainer.class);
	}
	
	public Collection<Trainer> findAll() {
		String hql = "FROM Trainer T "
				   + "WHERE T.isDelete = 'false'";
		Query q = getCurrentSession().createQuery(hql);
		Collection<Trainer> result = q.list();
		return result;
	}
	
	public Collection<Trainer> search(final String name) {
		String hql = "FROM Trainer T "
				   + "WHERE LOWER(T.name) LIKE LOWER(:name) "
				   + "AND T.isDelete = 'false'";
		Query q = getCurrentSession().createQuery(hql);
		q.setParameter("name", "%" + name + "%");
		Collection<Trainer> result = q.list();
		return result;
	}
}
