package xbc.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xbc.model.Room;
import xbc.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<Collection<Room>> findAll() {
		Collection<Room> list = roomService.findAll();
		ResponseEntity<Collection<Room>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
}
