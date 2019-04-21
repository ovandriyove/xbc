package xbc.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xbc.dao.RoomDao;
import xbc.model.Room;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomDao roomDao;
	
	@Override
	public Room findOne(Integer roomId) {
		return roomDao.findOne(roomId);
	}

	@Override
	public Collection<Room> findAll() {	
		return roomDao.findAll();
	}

	@Override
	public Room update(Room room) {		
		return roomDao.update(room);
	}

	@Override
	public void delete(Room room) {		
		roomDao.delete(room);
	}

	@Override
	public void deleteById(Integer roomId) {	
		roomDao.deleteById(roomId);
	}

	@Override
	public void save(Room room) {		
		roomDao.save(room);
	}
	
}
