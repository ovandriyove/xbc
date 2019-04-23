package xbc.dao;

import java.util.Collection;

import xbc.model.Clazz;

public interface ClazzDao {
	public Clazz findOne(Integer id);
	public Collection<Clazz> findAll();
	public Clazz update(Clazz clazz);
	public void delete(Clazz clazz);
	public void deleteById(Integer id);
	public void save(Clazz clazz);
	public Collection<Clazz> search(String name);
}
