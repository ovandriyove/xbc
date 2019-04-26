package xbc.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xbc.dao.ClazzDao;
import xbc.model.Clazz;

@Service
@Transactional
public class ClazzServiceImpl implements ClazzService {
	
	@Autowired
	private ClazzDao clazzDao;
	
	@Autowired
	private AuditLogService auditLogService;

	@Override
	public Clazz findOne(Integer id) {
		return clazzDao.findOne(id);
	}

	@Override
	public Collection<Clazz> findAll() {
		return clazzDao.findAll();
	}

	@Override
	public Clazz update(Clazz clazz) {
		return clazzDao.update(clazz);
	}

	@Override
	public void delete(Clazz clazz) {
		clazzDao.delete(clazz);
	}

	@Override
	public void deleteById(Integer id) {
		auditLogService.logDelete(auditLogService.objectToJsonString(id));
		clazzDao.deleteById(id);
	}

	@Override
	public void save(Clazz clazz , Integer sessionId) {
		clazz.setCreatedBy(sessionId);
		clazz.setCreatedOn(new Date());
		clazzDao.save(clazz);
		
		auditLogService.logInsert(auditLogService.objectToJsonString(clazz));
	}

	@Override
	public Collection<Clazz> search(String name) {
		return clazzDao.search(name);
	}
}
