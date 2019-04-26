package xbc.service;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xbc.dao.BatchTestDao;
import xbc.model.BatchTest;
import xbc.modelview.BatchTestView;

@Service
@Transactional
public class BatchTestServiceImpl implements BatchTestService {

	@Autowired
	private BatchTestDao batchTestDao;

	@Autowired
	private AuditLogService auditLogService;
	
	@Override
	public BatchTest findOne(Integer id) {

		return batchTestDao.findOne(id);
	}

	@Override
	public Collection<BatchTest> findAll() {

		return batchTestDao.findAll();
	}

	@Override
	public BatchTest update(BatchTest batchTest) {

		return batchTestDao.update(batchTest);
	}

	@Override
	public void delete(BatchTest batchTest) {

		batchTestDao.delete(batchTest);
	}

	@Override
	public void deleteById(Integer id) {

		batchTestDao.deleteById(id);
	}
	
	@Override
	public void save(BatchTestView batchTestView, Integer sessionId) {
		
		for (Integer testId : batchTestView.getTestId()) {
			BatchTest batchTest = new BatchTest();
			
			batchTest.setBatchId(batchTestView.getBatchId());
			batchTest.setTestId(testId);
			batchTest.setCreatedBy(sessionId);
			batchTest.setCreatedOn(new Date());
			batchTestDao.save(batchTest);
			
			auditLogService.logInsert(auditLogService.objectToJsonString(batchTest));
		}		
	}
}
