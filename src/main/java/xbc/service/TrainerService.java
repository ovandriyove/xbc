package xbc.service;

import java.util.Collection;

import xbc.model.Trainer;

public interface TrainerService {
	public Trainer findOne(Integer trainerId);
	public Collection<Trainer> findAll();
	public Trainer update(Trainer trainer);
	public void delete(Trainer trainer);
	public void deleteById(Integer trainerId);
	public void save(Trainer trainer);
}
