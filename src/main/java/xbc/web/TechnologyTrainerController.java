package xbc.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xbc.model.TechnologyTrainer;
import xbc.service.TechnologyTrainerService;

@RestController
@RequestMapping("/technology-trainer")
public class TechnologyTrainerController {
	
	@Autowired
	private TechnologyTrainerService technologyTrainerService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Collection<TechnologyTrainer>> findAll(@PathVariable("id") Integer id) {
		Collection<TechnologyTrainer> list = technologyTrainerService.findAll(id);
		ResponseEntity<Collection<TechnologyTrainer>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
}
