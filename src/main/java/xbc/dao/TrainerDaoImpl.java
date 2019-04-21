package xbc.dao;

import org.springframework.stereotype.Repository;

import xbc.model.Trainer;

@Repository
public class TrainerDaoImpl extends AbstractHibernateDao<Trainer> implements TrainerDao {

	public TrainerDaoImpl () {
		setClazz(Trainer.class);
	}
}
