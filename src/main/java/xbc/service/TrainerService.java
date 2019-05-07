package xbc.service;

import java.util.Collection;

import xbc.model.Trainer;

public interface TrainerService {
	public Trainer findOne(Integer trainerId);
	public Collection<Trainer> findAll();
	public Trainer update(Trainer trainer, Integer sessionId);
	public void delete(Trainer trainer);
	public void deleteById(Integer trainerId);
	public void save(Trainer trainer, Integer sessionId);
	public Collection<Trainer> search(String trainer);
	public Trainer softDeleteById(Integer id, Integer sessionId);
}
