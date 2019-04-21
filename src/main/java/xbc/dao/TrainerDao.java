package xbc.dao;

import java.util.Collection;

import xbc.model.Trainer;

public interface TrainerDao {
	public Trainer findOne(Integer trainerId);
	public Collection<Trainer> findAll();
	public Trainer update(Trainer trainer);
	public void delete(Trainer trainer);
	public void deleteById(Integer trainerId);
	public void save(Trainer trainer);
}
