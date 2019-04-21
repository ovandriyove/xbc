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
	@Column(name="room_id", length=11, columnDefinition="serial")
	private Integer roomId;
	
	@Column(name="name", length=50)
	private String name;

	public Integer getRoomId() {
		return roomId;
	}

	public String getName() {
		return name;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public void setName(String name) {
		this.name = name;
	}
}
