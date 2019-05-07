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

import xbc.model.Technology;
import xbc.service.TechnologyService;

@RestController
@RequestMapping("/technology")
public class TechnologyController {
	
	@Autowired
	private TechnologyService technologyService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<Collection<Technology>> search(@RequestParam(value = "name") String name) {
		Collection<Technology> list = technologyService.search(name);
		ResponseEntity<Collection<Technology>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Technology> findOne(@PathVariable("id") Integer id) {
		Technology technology = technologyService.findOne(id);
		ResponseEntity<Technology> result = new ResponseEntity<>(technology, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<Technology> save(@RequestBody Technology technology, HttpSession session) {
		technologyService.save(technology, (Integer) session.getAttribute("sessionId"));
		ResponseEntity<Technology> result = new ResponseEntity<> (HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Technology> softDeleteById(@PathVariable("id") Integer id, HttpSession session) {
		technologyService.softDeleteById(id, (Integer) session.getAttribute("sessionId"));
		ResponseEntity<Technology> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/", method=RequestMethod.PUT)
	public ResponseEntity<Technology> update(@RequestBody Technology technology, HttpSession session) {
		technologyService.update(technology, (Integer) session.getAttribute("sessionId"));
		ResponseEntity<Technology> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}

}
