package xbc.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import xbc.model.TechnologyTrainer;

@Repository
public class TechnologyTrainerDaoImpl extends AbstractHibernateDao<TechnologyTrainer> implements TechnologyTrainerDao {
	
	public TechnologyTrainerDaoImpl() {
		setClazz(TechnologyTrainer.class);		
	}

	@Override
	public Collection<TechnologyTrainer> findAll(Integer id) {
		String hql = "FROM TechnologyTrainer TT "
				   + "WHERE TT.technologyId = :idSekarang";
		Query q = getCurrentSession().createQuery(hql);
		q.setParameter("idSekarang", id);
		Collection<TechnologyTrainer> result = q.list();
		return result;
	}

	
}
