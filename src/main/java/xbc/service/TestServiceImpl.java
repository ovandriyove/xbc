package xbc.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xbc.dao.TestDao;
import xbc.model.Test;

@Service
@Transactional
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestDao testDao;

	@Override
	public Collection<Test> findAll() {
		return testDao.findAll();
	}
	
}
