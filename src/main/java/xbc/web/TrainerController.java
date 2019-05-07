package xbc.web;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xbc.model.Trainer;
import xbc.service.TrainerService;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
	
	@Autowired
	private TrainerService trainerService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<Collection<Trainer>> search(@RequestParam(value = "name") String name) {
		Collection<Trainer> list = trainerService.search(name);
		ResponseEntity<Collection<Trainer>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Trainer> findOne(@PathVariable("id") Integer id) {
		Trainer trainer = trainerService.findOne(id);
		ResponseEntity<Trainer> result = new ResponseEntity<>(trainer, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<Trainer> save(@RequestBody Trainer trainer, HttpSession session) {
		trainerService.save(trainer, (Integer) session.getAttribute("sessionId"));
		ResponseEntity<Trainer> result = new ResponseEntity<> (HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Trainer> softDeleteById(@PathVariable("id") Integer id, HttpSession session) {
		trainerService.softDeleteById(id, (Integer) session.getAttribute("sessionId"));
		ResponseEntity<Trainer> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/", method=RequestMethod.PUT)
	public ResponseEntity<Trainer> update(@RequestBody Trainer trainer, HttpSession session) {
		trainerService.update(trainer, (Integer) session.getAttribute("sessionId"));
		ResponseEntity<Trainer> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}
}
