package xbc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_trainer")
public class Trainer implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="trainer_id", length=11, columnDefinition="serial")
	private Integer trainerId;
	
	@Column(name="name", length=50)
	private String name;

	public Integer getTrainerId() {
		return trainerId;
	}

	public String getName() {
		return name;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	public void setName(String name) {
		this.name = name;
	}
}
