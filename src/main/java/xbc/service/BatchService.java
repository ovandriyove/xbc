package xbc.service;

import java.util.Collection;

import xbc.model.Batch;

public interface BatchService {
	public Batch findOne(Integer id);
	public Collection<Batch> findAll();
	public Batch update(Batch batch, Integer sessionId);
	public void delete(Batch batch);
	public void deleteById(Integer id);
	public Integer save(Batch batch, Integer sessionId);
	public Collection<Batch> search(String name);
	public Batch softDeleteById(Integer id, Integer sessionId);
}
