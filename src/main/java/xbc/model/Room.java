package xbc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_room")
public class Room implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", length=11, columnDefinition="serial")
	private Integer id;
	
	@Column(name="name", length=255)
	private String name;

	@Column(name="is_delete")
	private boolean isdelete;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isIsdelete() {
		return isdelete;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIsdelete(boolean isdelete) {
		this.isdelete = isdelete;
	}
}
