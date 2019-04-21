package xbc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_bootcamptype")
public class BootcampType implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bootcamp_type_id", length=11, columnDefinition="serial")
	private Integer bootcampTypeId;
	
	@Column(name="name", length=50)
	private String name;

	public Integer getBootcampTypeId() {
		return bootcampTypeId;
	}

	public String getName() {
		return name;
	}

	public void setBootcampTypeId(Integer bootcampTypeId) {
		this.bootcampTypeId = bootcampTypeId;
	}

	public void setName(String name) {
		this.name = name;
	}
}
