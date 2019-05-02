package xbc.service;

import java.util.Collection;

import xbc.model.TechnologyTrainer;

public interface TechnologyTrainerService {

	public Collection<TechnologyTrainer> findAll(Integer id);
}
