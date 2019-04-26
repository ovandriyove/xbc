package xbc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="t_batch_test")
public class BatchTest implements Serializable {
	
//	Id
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", length=11, columnDefinition="serial")
	private Integer Id;
	
	@ManyToOne
	@JoinColumn(name="batch_id", updatable=false, insertable=false)
	private Batch batch;
	
	@Column(name="batch_id",length=11)
	private Integer batchId;
	
	@ManyToOne
	@JoinColumn(name="test_id", updatable=false, insertable=false)
	private Test test;
	
	@Column(name="test_id", length=11)
	private Integer testId;
	
//	Waktu
	@Column(name="created_on")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Jakarta")
	private Date createdOn;
	
//	Edit Component
	@Column(name="created_by")
	private Integer createdBy;

	public Integer getId() {
		return Id;
	}

	public Batch getBatch() {
		return batch;
	}

	public Integer getBatchId() {
		return batchId;
	}

	public Test getTest() {
		return test;
	}

	public Integer getTestId() {
		return testId;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}	
}
