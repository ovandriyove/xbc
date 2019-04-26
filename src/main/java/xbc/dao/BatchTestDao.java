package xbc.dao;

import java.util.Collection;

import xbc.model.BatchTest;

public interface BatchTestDao {
	public BatchTest findOne(Integer id);
	public Collection<BatchTest> findAll();
	public BatchTest update(BatchTest batchTest);
	public void delete(BatchTest batchTest);
	public void deleteById(Integer id);
	public void save(BatchTest batchTest);
//	public Collection<BatchTest> findTestByBatchId(Integer batchId); 
}
