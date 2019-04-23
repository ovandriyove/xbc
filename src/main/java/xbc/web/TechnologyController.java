package xbc.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xbc.model.Technology;
import xbc.service.TechnologyService;

@RestController
@RequestMapping("/technology")
public class TechnologyController {
	
	@Autowired
	private TechnologyService technologyService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<Collection<Technology>> findAll() {
		Collection<Technology> list = technologyService.findAll();
		ResponseEntity<Collection<Technology>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
}
