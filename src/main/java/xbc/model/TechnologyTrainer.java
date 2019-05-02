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
@Table(name="t_technology_trainer")
public class TechnologyTrainer implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", length=11, columnDefinition="serial")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="technology_id", updatable=false, insertable=false)
	private Technology technology;
	
	@Column(name="technology_id",length=11)
	private Integer technologyId;
	
	@ManyToOne
	@JoinColumn(name="trainer_id", updatable=false, insertable=false)
	private Trainer trainer;
	
	@Column(name="trainer_id", length=11)
	private Integer trainerId;
	
//	Waktu
	@Column(name="created_on")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Jakarta")
	private Date createdOn;
	
//	Edit Component
	@Column(name="created_by")
	private Integer createdBy;

	public Integer getId() {
		return id;
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

	public Date getCreatedOn() {
		return createdOn;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	} 
	
}
