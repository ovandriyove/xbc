package xbc.dao;

import org.springframework.stereotype.Repository;

import xbc.model.BootcampType;

@Repository
public class BootcampTypeDaoImpl extends AbstractHibernateDao<BootcampType> implements BootcampTypeDao {

	public BootcampTypeDaoImpl() {
		setClazz(BootcampType.class);
	}
}
