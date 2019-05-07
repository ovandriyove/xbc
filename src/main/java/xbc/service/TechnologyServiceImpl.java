package xbc.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xbc.dao.TechnologyDao;
import xbc.model.Technology;

@Service
@Transactional
public class TechnologyServiceImpl implements TechnologyService {
	
	@Autowired
	private AuditLogService auditLogService;
	
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
	public Technology update(Technology newTechnology, Integer sessionId) {
		Technology technology = technologyDao.findOne(newTechnology.getId());
		String jsonBefore = auditLogService.objectToJsonString(technology);
		
		technology.setModifiedBy(sessionId);
		technology.setModifiedOn(new Date());
		technology.setName(newTechnology.getName());
		technology.setNotes(newTechnology.getNotes());
		Technology result = technologyDao.update(technology);
		
		String jsonAfter = auditLogService.objectToJsonString(technology);
		auditLogService.logUpdate(jsonBefore, jsonAfter, sessionId);
		return result;
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
	public void save(Technology technology, Integer sessionId) {		
		technology.setCreateBy(sessionId);
		technology.setCreatedOn(new Date());
		technology.setDelete(false);
		technologyDao.save(technology);
		
		auditLogService.logInsert(auditLogService.objectToJsonString(technology), sessionId);
	}

	@Override
	public Collection<Technology> search(String technology) {
		return technologyDao.search(technology);
	}

	@Override
	public Technology softDeleteById(Integer id, Integer sessionId) {
		Technology technology = technologyDao.findOne(id);
		String jsonBefore = auditLogService.objectToJsonString(technology);
		
		technology.setDeleteBy(sessionId);
		technology.setDeleteOn(new Date());
		technology.setDelete(true);
		Technology result = technologyDao.update(technology);
		
		String jsonAfter = auditLogService.objectToJsonString(technology);
		auditLogService.logUpdate(jsonBefore, jsonAfter, sessionId);
		return result;
	}
	
}
