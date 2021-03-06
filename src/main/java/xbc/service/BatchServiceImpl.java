package xbc.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xbc.dao.BatchDao;
import xbc.model.Batch;
import xbc.model.Trainer;

@Service
@Transactional
public class BatchServiceImpl implements BatchService {
	
	@Autowired
	private BatchDao batchDao;
	
	@Autowired
	private AuditLogService auditLogService;

	@Override
	public Batch findOne(Integer id) {
		return batchDao.findOne(id);
	}

	@Override
	public Collection<Batch> findAll() {
		return batchDao.findAll();
	}

	@Override
	public Batch update(Batch newBatch, Integer sessionId) {
		Batch batch = batchDao.findOne(newBatch.getId());
		String jsonBefore = auditLogService.objectToJsonString(batch);
		
		batch.setModifiedBy(sessionId);
		batch.setModifiedOn(new Date());
		batch.setName(newBatch.getName());
		batch.setTechnologyId(newBatch.getTechnologyId());
		batch.setBootcampTypeId(newBatch.getBootcampTypeId());
		batch.setRoomId(newBatch.getRoomId());
		batch.setTrainerId(newBatch.getTrainerId());
		batch.setPeriodFrom(newBatch.getPeriodFrom());
		batch.setPeriodTo(newBatch.getPeriodTo());
		batch.setNotes(newBatch.getNotes());
		Batch result = batchDao.update(batch);
		
		String jsonAfter = auditLogService.objectToJsonString(batch);
		auditLogService.logUpdate(jsonBefore, jsonAfter, sessionId);
		return result;
	}

	@Override
	public void delete(Batch batch) {
		batchDao.delete(batch);
	}

	@Override
	public void deleteById(Integer id) {
		batchDao.deleteById(id);
	}

	@Override
	public void save(Batch batch, Integer sessionId) {
		batch.setCreatedBy(sessionId);
		batch.setCreatedOn(new Date());
		batch.setDelete(false);	
		auditLogService.logInsert(auditLogService.objectToJsonString(batch), sessionId);
		
		batchDao.save(batch);
	}

	@Override
	public Collection<Batch> search(String name) {
		return batchDao.search(name);
	}

	@Override
	public Batch softDeleteById(Integer id, Integer sessionId) {
		Batch batch = batchDao.findOne(id);
		String jsonBefore = auditLogService.objectToJsonString(batch);
		
		batch.setDeleteBy(sessionId);
		batch.setDeleteOn(new Date());
		batch.setDelete(true);
		Batch result = batchDao.update(batch);
		
		String jsonAfter = auditLogService.objectToJsonString(batch);
		auditLogService.logUpdate(jsonBefore, jsonAfter, sessionId);
		return result;
	}
	
	@Override
	public boolean checkDuplicate(String name, Integer id) {
		return batchDao.checkDuplicate(name, id);
	}

	@Override
	public Collection<Trainer> trainerTersedia(Date periodFromSekarang, Date periodToSekarang) {
		return batchDao.trainerTersedia(periodFromSekarang, periodToSekarang);
	}
	
	
}
