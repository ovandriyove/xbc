package xbc.service;

import java.util.Collection;
import java.util.Date;

import xbc.model.Batch;
import xbc.model.Trainer;

public interface BatchService {
	public Batch findOne(Integer id);
	public Collection<Batch> findAll();
	public Batch update(Batch batch, Integer sessionId);
	public void delete(Batch batch);
	public void deleteById(Integer id);
	public void save(Batch batch, Integer sessionId);
	public Collection<Batch> search(String name);
	public Batch softDeleteById(Integer id, Integer sessionId);
	public boolean checkDuplicate(String name, Integer id);
	public Collection<Trainer> trainerTersedia(Date periodFromSekarang, Date periodToSekarang);
}
