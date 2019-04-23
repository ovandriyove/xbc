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
@Table(name="t_clazz")
public class Clazz implements Serializable {
	
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
	@JoinColumn(name="biodata_id", updatable=false, insertable=false)
	private Biodata biodata;
	
	@Column(name="biodata_id", length=11)
	private Integer biodataId;
	
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

	public Biodata getBiodata() {
		return biodata;
	}

	public Integer getBiodataId() {
		return biodataId;
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

	public void setBiodata(Biodata biodata) {
		this.biodata = biodata;
	}

	public void setBiodataId(Integer biodataId) {
		this.biodataId = biodataId;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

}
