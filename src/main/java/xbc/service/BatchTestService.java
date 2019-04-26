 package xbc.service;

import java.util.Collection;

import xbc.model.BatchTest;
import xbc.modelview.BatchTestView;

public interface BatchTestService {
	public BatchTest findOne(Integer id);
	public Collection<BatchTest> findAll();
	public BatchTest update(BatchTest batchTest);
	public void delete(BatchTest batchTest);
	public void deleteById(Integer id);
	public void save(BatchTestView batchTestView, Integer sessionId);
}
