package xbc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="t_bootcamptype")
public class BootcampType implements Serializable {

//	Id	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", length=11, columnDefinition="serial")
	private Integer id;
	
//	input
	@Column(name="name", length=255, nullable=false)
	private String name;
	
	@Column(name="notes", length=255)
	private String notes;
	
//	Waktu	
	@Column(name="created_on", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Jakarta")
	private Date createdOn;
	
	@Column(name="modified_on")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Jakarta")
	private Date modifiedOn;
	
	@Column(name="delete_on")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Jakarta")
	private Date deleteOn;

//	Modify	
	@Column(name="delete_by", length=11)
	private Integer deleteBy;
	
	@Column(name="create_by", length=11, nullable=false)
	private Integer createBy;
	
	@Column(name="modified_by", length=11)
	private Integer modifiedBy;
	
	@Column(name="is_delete", nullable=false)
	private boolean isDelete;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getNotes() {
		return notes;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public Date getDeleteOn() {
		return deleteOn;
	}

	public Integer getDeleteBy() {
		return deleteBy;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public void setDeleteOn(Date deleteOn) {
		this.deleteOn = deleteOn;
	}

	public void setDeleteBy(Integer deleteBy) {
		this.deleteBy = deleteBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
}
