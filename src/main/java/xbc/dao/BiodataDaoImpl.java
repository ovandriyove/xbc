package xbc.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import xbc.model.Biodata;
import xbc.model.Biodata;

@Repository
public class BiodataDaoImpl extends AbstractHibernateDao<Biodata> implements BiodataDao  {
	
	public BiodataDaoImpl () {
		setClazz(Biodata.class);
	}
	
	public Collection<Biodata> searchByName(final String name) {
		String hql = "FROM Biodata B WHERE LOWER(B.name) LIKE LOWER(:name)";
		Query q = getCurrentSession().createQuery(hql);
		q.setParameter("name", "%" + name + "%");
		Collection<Biodata> result = q.list();
		return result;
	}
	
	public Collection<Biodata> searchByMajors(final String majors) {
		String hql = "FROM Biodata B WHERE LOWER(B.majors) LIKE LOWER(:majors)";
		Query q = getCurrentSession().createQuery(hql);
		q.setParameter("majors", "%" + majors + "%");
		Collection<Biodata> result = q.list();
		return result;
	}
}
