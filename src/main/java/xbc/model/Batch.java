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
@Table(name="t_batch")
public class Batch implements Serializable {
	
//	Id	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", length=11, nullable=false, columnDefinition = "serial")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="room_id", updatable=false, insertable=false)
	private Room room;
	
	@Column(name="room_id", length=11)
	private Integer roomId;
	
	@ManyToOne
	@JoinColumn(name="technology_id", updatable=false, insertable=false)
	private Technology technology;
	
	@Column(name="technology_id", length=11)
	private Integer technologyId;
	
	@ManyToOne
	@JoinColumn(name="trainer_id", updatable=false, insertable=false)
	private Trainer trainer;
	
	@Column(name="trainer_id", length=11)
	private Integer trainerId;
	
	@ManyToOne
	@JoinColumn(name="bootcamp_type_id", updatable=false, insertable=false)
	private BootcampType bootcampType;
	
	@Column(name="bootcamp_type_id")
	private Integer bootcampTypeId;
	
//	Batch Component	
	@Column(name="name", length=255)
	private String name;
	
	@Column(name="notes", length=255)
	private String notes;
	
//	Waktu 
	
	@Column(name="period_from")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Asia/Jakarta")
	private Date periodFrom;
	
	@Column(name="period_to")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Asia/Jakarta")
	private Date periodTo;

	@Column(name="created_on")
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

//	Edit Component
	@Column(name="created_by")
	private Integer createdBy;
	
	@Column(name="modified_by")
	private Integer modifiedBy;
	
	@Column(name="delete_by")
	private Integer deleteBy;
	
	@Column(name="is_delete")
	private boolean isDelete;

	public Integer getId() {
		return id;
	}

	public Room getRoom() {
		return room;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public Technology getTechnology() {
		return technology;
	}

	public Integer getTechnologyId() {
		return technologyId;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public Integer getTrainerId() {
		return trainerId;
	}

	public BootcampType getBootcampType() {
		return bootcampType;
	}

	public Integer getBootcampTypeId() {
		return bootcampTypeId;
	}

	public String getName() {
		return name;
	}

	public String getNotes() {
		return notes;
	}

	public Date getPeriodFrom() {
		return periodFrom;
	}

	public Date getPeriodTo() {
		return periodTo;
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

	public Integer getCreatedBy() {
		return createdBy;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public Integer getDeleteBy() {
		return deleteBy;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	public void setTechnologyId(Integer technologyId) {
		this.technologyId = technologyId;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	public void setBootcampType(BootcampType bootcampType) {
		this.bootcampType = bootcampType;
	}

	public void setBootcampTypeId(Integer bootcampTypeId) {
		this.bootcampTypeId = bootcampTypeId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setPeriodFrom(Date periodFrom) {
		this.periodFrom = periodFrom;
	}

	public void setPeriodTo(Date periodTo) {
		this.periodTo = periodTo;
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

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public void setDeleteBy(Integer deleteBy) {
		this.deleteBy = deleteBy;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	
}
