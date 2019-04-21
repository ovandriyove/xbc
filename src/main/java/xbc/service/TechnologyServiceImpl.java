package xbc.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xbc.dao.TechnologyDao;
import xbc.model.Technology;

@Service
@Transactional
public class TechnologyServiceImpl implements TechnologyService {
	
	@Autowired
	private TechnologyDao technologyDao;

	@Override
	public Technology findOne(Integer technologyId) {		
		return technologyDao.findOne(technologyId);
	}

	@Override
	public Collection<Technology> findAll() {		
		return technologyDao.findAll();
	}

	@Override
	public Technology update(Technology technology) {		
		return technologyDao.update(technology);
	}

	@Override
	public void delete(Technology technology) {		
		technologyDao.delete(technology);
	}

	@Override
	public void deleteById(Integer technologyId) {		
		technologyDao.deleteById(technologyId);
	}

	@Override
	public void save(Technology technology) {		
		technologyDao.save(technology);
	}
	
}
