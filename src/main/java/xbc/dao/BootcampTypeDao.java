package xbc.dao;

import java.util.Collection;

import xbc.model.BootcampType;

public interface BootcampTypeDao {
	public BootcampType findOne(Integer bootcampTypeId);
	public Collection<BootcampType> findAll();
	public BootcampType update(BootcampType bootcampType);
	public void delete(BootcampType bootcampType);
	public void deleteById(Integer bootcampTypeId);
	public void save(BootcampType bootcampType);
}
