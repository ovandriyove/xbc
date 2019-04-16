package xbc.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import xbc.model.Menu;

@Repository
public class MenuDaoImpl extends AbstractHibernateDao<Menu> implements MenuDao {
	
	public MenuDaoImpl () {
		setClazz(Menu.class);
	}
	
	public Collection<Menu> search(final String title) {
		String hql = "FROM Menu M WHERE LOWER(M.title) LIKE LOWER(:title) AND M.isDelete = 'false'";
		Query q = getCurrentSession().createQuery(hql);
		q.setParameter("title", "%" + title + "%");
		Collection<Menu> result = q.list();
		return result;
	}
	
//	public void deleteByStatus(Integer id) {
//		Session session = getCurrentSession();
//		Menu menu = (Menu) session.get(Menu.class, id);
//		menu.setDelete(true);
//		session.update(menu);		
//	}
}
