package xbc.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xbc.dao.BootcampTestTypeDao;
import xbc.model.BootcampTestType;

@Service
@Transactional
public class BootcampTestTypeServiceImpl implements BootcampTestTypeService {
	
	@Autowired
	private BootcampTestTypeDao bootcampTestTypeDao;

	@Override
	public Collection<BootcampTestType> findAll() {
		return bootcampTestTypeDao.findAll();
	}
	
	
	
}
