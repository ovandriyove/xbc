package xbc.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xbc.dao.BatchDao;
import xbc.model.Batch;

@Service
@Transactional
public class BatchServiceImpl implements BatchService {
	
	@Autowired
	private BatchDao batchDao;

	@Override
	public Batch findOne(Integer id) {
		return batchDao.findOne(id);
	}

	@Override
	public Collection<Batch> findAll() {
		return batchDao.findAll();
	}

	@Override
	public Batch update(Batch newBatch) {
		Batch batch = batchDao.findOne(newBatch.getId());
		
		batch.setModifiedBy(1);
		batch.setModifiedOn(new Date());
		batch.setName(newBatch.getName());
		batch.setTechnology(newBatch.getTechnology());
		batch.setBootcampType(newBatch.getBootcampType());
		batch.setRoom(newBatch.getRoom());
		batch.setTrainer(newBatch.getTrainer());
		batch.setPeriodTo(newBatch.getPeriodTo());
		batch.setPeriodForm(newBatch.getPeriodForm());
		batch.setNotes(newBatch.getNotes());
		Batch result = batchDao.update(batch);
		
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
	public void save(Batch batch) {
		batch.setCreatedBy(1);
		batch.setCreatedOn(new Date());
		batch.setDelete(false);
		
		batchDao.save(batch);
	}

	@Override
	public Collection<Batch> search(String name) {
		return batchDao.search(name);
	}

	@Override
	public Batch softDeleteById(Integer id) {
		Batch batch = batchDao.findOne(id);
		batch.setDeleteBy(1);
		batch.setDeleteOn(new Date());
		batch.setDelete(true);
		Batch result = batchDao.update(batch);
		
		return result;
	}
}
