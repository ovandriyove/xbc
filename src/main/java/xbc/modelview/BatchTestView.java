package xbc.modelview;

import java.util.Collection;
import java.util.List;

import xbc.model.Test;

public class BatchTestView {
	
	private Integer Id;
	private Integer batchId;
	private Collection<Integer> testId;
	public Integer getId() {
		return Id;
	}
	public Integer getBatchId() {
		return batchId;
	}
	public Collection<Integer> getTestId() {
		return testId;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}
	public void setTestId(Collection<Integer> testId) {
		this.testId = testId;
	}

	
}
