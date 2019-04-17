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
		String hql = "FROM Menu M "
				   + "WHERE (LOWER(M.name) LIKE LOWER(:nameOrMajors) "
				   + "OR LOWER(M.majors) LIKE LOWER(:nameOrMajors) " 
				   + "AND M.isDelete = 'false'";
		Query q = getCurrentSession().createQuery(hql);
		q.setParameter("title", "%" + nameOrMajors + "%");
		Collection<Biodata> result = q.list();
		return result;
	}
}
