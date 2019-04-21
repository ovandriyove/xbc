package xbc.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xbc.dao.BootcampTypeDao;
import xbc.model.BootcampType;

@Service
@Transactional
public class BootcampTypeServiceImpl implements BootcampTypeService {

	@Autowired
	private BootcampTypeDao bootcampTypeDao;

	@Override
	public BootcampType findOne(Integer bootcampTypeId) {
		return bootcampTypeDao.findOne(bootcampTypeId);
	}

	@Override
	public Collection<BootcampType> findAll() {
		return bootcampTypeDao.findAll();
	}

	@Override
	public BootcampType update(BootcampType bootcampType) {
		return bootcampTypeDao.update(bootcampType);
	}

	@Override
	public void delete(BootcampType bootcampType) {
		bootcampTypeDao.delete(bootcampType);
	}

	@Override
	public void deleteById(Integer bootcampTypeId) {
		bootcampTypeDao.deleteById(bootcampTypeId);
	}

	@Override
	public void save(BootcampType bootcampType) {
		bootcampTypeDao.save(bootcampType);
	}
	
}
