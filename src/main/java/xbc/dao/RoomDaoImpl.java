package xbc.dao;

import org.springframework.stereotype.Repository;

import xbc.model.Room;

@Repository
public class RoomDaoImpl extends AbstractHibernateDao<Room> implements RoomDao {

		public RoomDaoImpl() {
			setClazz(Room.class);
		}
}
