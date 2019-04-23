package xbc.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import xbc.model.Room;

@Repository
public class RoomDaoImpl extends AbstractHibernateDao<Room> implements RoomDao {

	public RoomDaoImpl() {
		setClazz(Room.class);
	}

	public Collection<Room> findAll() {
		String hql = "FROM Room R "
				   + "WHERE R.isDelete = 'false'";
		Query q = getCurrentSession().createQuery(hql);
		Collection<Room> result = q.list();
		return result;
	}
}
