package xbc.dao;

import java.util.Collection;

import xbc.model.Technology;

public interface TechnologyDao {
	public Technology findOne(Integer technologyId);
	public Collection<Technology> findAll();
	public Technology update(Technology technology);
	public void delete(Technology technology);
	public void deleteById(Integer technologyId);
	public void save(Technology technology);
	public Collection<Technology> search(String technology);
}
