package xbc.dao;

import java.util.Collection;
import java.util.Date;

import xbc.model.Batch;
import xbc.model.Trainer;

public interface BatchDao {
	public Batch findOne(Integer id);
	public Collection<Batch> findAll();
	public Batch update(Batch batch);
	public void delete(Batch batch);
	public void deleteById(Integer id);
	public void save(Batch batch);
	public Collection<Batch> search(String name);
	public boolean checkDuplicate(String name, Integer Id);
	public Collection<Trainer> trainerTersedia(Date periodFromSekarang, Date periodToSekarang);
}
