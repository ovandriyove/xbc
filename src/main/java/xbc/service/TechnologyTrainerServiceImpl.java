package xbc.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xbc.dao.TechnologyTrainerDao;
import xbc.model.TechnologyTrainer;

@Service
@Transactional
public class TechnologyTrainerServiceImpl implements TechnologyTrainerService {

	@Autowired
	private TechnologyTrainerDao technologyTrainerDao;

	@Override
	public Collection<TechnologyTrainer> findAll(Integer id) {
		
		return technologyTrainerDao.findAll(id);
	}
	
}
