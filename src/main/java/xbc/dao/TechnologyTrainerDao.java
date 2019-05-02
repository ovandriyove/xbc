package xbc.dao;

import java.util.Collection;

import xbc.model.TechnologyTrainer;

public interface TechnologyTrainerDao {
	public Collection<TechnologyTrainer> findAll(Integer id);
}
