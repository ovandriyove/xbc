package xbc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_test")
public class Test implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", length=11, columnDefinition="serial")
	private Integer id;
	
	@Column(name="name", length=255)
	private String name;
	
	@Column(name="is_bootcamp_test")
	private boolean isBootcampTest;
	
	@Column(name="is_delete")
	private boolean isDelete;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isBootcampTest() {
		return isBootcampTest;
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

	public void setBootcampTest(boolean isBootcampTest) {
		this.isBootcampTest = isBootcampTest;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
}
