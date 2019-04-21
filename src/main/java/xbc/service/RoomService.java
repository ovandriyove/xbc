package xbc.service;

import java.util.Collection;

import xbc.model.Room;

public interface RoomService {
	public Room findOne(Integer roomId);
	public Collection<Room> findAll();
	public Room update(Room room);
	public void delete(Room room);
	public void deleteById(Integer roomId);
	public void save(Room room);
}
