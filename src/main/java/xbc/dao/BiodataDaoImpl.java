package xbc.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import xbc.model.Biodata;

@Repository
public class BiodataDaoImpl extends AbstractHibernateDao<Biodata> implements BiodataDao  {
	
	public BiodataDaoImpl () {
		setClazz(Biodata.class);
	}
	
	public Collection<Biodata> search(final String nameOrMajors) {
		String hql = "FROM Biodata B "
				   + "WHERE (LOWER(B.name) LIKE LOWER(:nameOrMajors) "
				   + "OR LOWER(B.majors) LIKE LOWER(:nameOrMajors)) "
				   + "AND B.isDelete = 'false'";
		Query q = getCurrentSession().createQuery(hql);
		q.setParameter("nameOrMajors", "%" + nameOrMajors + "%");
		Collection<Biodata> result = q.list();
		return result;
	}
	
	public Collection<Biodata> findAll() {
		String hql = "FROM Biodata B "
				   + "WHERE B.isDelete = 'false'";
		Query q = getCurrentSession().createQuery(hql);
		Collection<Biodata> result = q.list();
		return result;
	}
}
