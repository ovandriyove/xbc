package xbc.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xbc.model.Trainer;
import xbc.service.TrainerService;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
	
	@Autowired
	private TrainerService trainerService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<Collection<Trainer>> findAll() {
		Collection<Trainer> list = trainerService.findAll();
		ResponseEntity<Collection<Trainer>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
}
