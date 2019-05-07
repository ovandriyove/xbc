package xbc.service;

import java.util.Collection;

import xbc.model.Technology;

public interface TechnologyService {
	public Technology findOne(Integer technologyId);
	public Collection<Technology> findAll();
	public Technology update(Technology technology, Integer sessionId);
	public void delete(Technology technology);
	public void deleteById(Integer technologyId);
	public void save(Technology technology, Integer sessionId);
	public Collection<Technology> search(String technology);
	public Technology softDeleteById(Integer id, Integer sessionId);
}
