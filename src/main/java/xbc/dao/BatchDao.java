package xbc.dao;

import java.util.Collection;

import xbc.model.Batch;

public interface BatchDao {
	public Batch findOne(Integer id);
	public Collection<Batch> findAll();
	public Batch update(Batch batch);
	public void delete(Batch batch);
	public void deleteById(Integer id);
	public void save(Batch batch);
	public Collection<Batch> search(String name);
}
