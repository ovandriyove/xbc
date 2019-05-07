package xbc.service;

import java.util.Collection;
import java.util.Date;

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
	
	@Autowired
	private AuditLogService auditLogService;

	@Override
	public Trainer findOne(Integer trainerId) {
		return trainerDao.findOne(trainerId);
	}

	@Override
	public Collection<Trainer> findAll() {
		return trainerDao.findAll();
	}

	@Override
	public Trainer update(Trainer newTrainer, Integer sessionId) {
		Trainer trainer = trainerDao.findOne(newTrainer.getId());
		String jsonBefore = auditLogService.objectToJsonString(trainer);
		
		trainer.setModifiedBy(sessionId);
		trainer.setModifiedOn(new Date());
		trainer.setName(newTrainer.getName());
		trainer.setNotes(newTrainer.getNotes());
		Trainer result = trainerDao.update(trainer);
		
		String jsonAfter = auditLogService.objectToJsonString(trainer);
		auditLogService.logUpdate(jsonBefore, jsonAfter, sessionId);
		return result;
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
	public void save(Trainer trainer, Integer sessionId) {
		trainer.setCreateBy(sessionId);
		trainer.setCreatedOn(new Date());
		trainer.setDelete(false);
		trainerDao.save(trainer);
		
		auditLogService.logInsert(auditLogService.objectToJsonString(trainer), sessionId);
	}

	@Override
	public Collection<Trainer> search(String trainer) {
		return trainerDao.search(trainer);
	}

	@Override
	public Trainer softDeleteById(Integer id, Integer sessionId) {
		Trainer trainer = trainerDao.findOne(id);
		String jsonBefore = auditLogService.objectToJsonString(trainer);
		
		trainer.setDeleteBy(sessionId);
		trainer.setDeleteOn(new Date());
		trainer.setDelete(true);
		Trainer result = trainerDao.update(trainer);
		
		String jsonAfter = auditLogService.objectToJsonString(trainer);
		auditLogService.logUpdate(jsonBefore, jsonAfter, sessionId);
		return result;
	}
	
}
