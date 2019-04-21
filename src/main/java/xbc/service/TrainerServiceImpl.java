package xbc.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xbc.dao.TrainerDao;
import xbc.model.Trainer;

@Service
@Transactional
public class TrainerServiceImpl implements TrainerService {
	
	@Autowired
	private TrainerDao trainerDao;

	@Override
	public Trainer findOne(Integer trainerId) {
		return trainerDao.findOne(trainerId);
	}

	@Override
	public Collection<Trainer> findAll() {
		return trainerDao.findAll();
	}

	@Override
	public Trainer update(Trainer trainer) {
		return trainerDao.update(trainer);
	}

	@Override
	public void delete(Trainer trainer) {
		trainerDao.delete(trainer);
	}

	@Override
	public void deleteById(Integer trainerId) {
		trainerDao.deleteById(trainerId);
	}

	@Override
	public void save(Trainer trainer) {
		trainerDao.save(trainer);
	}
	
}
