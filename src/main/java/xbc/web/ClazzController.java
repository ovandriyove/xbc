package xbc.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xbc.model.Clazz;
import xbc.service.ClazzService;

@RestController
@RequestMapping("/clazz")
public class ClazzController {
	
	@Autowired
	private ClazzService clazzService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<Collection<Clazz>> search(@RequestParam(value = "name") String name) {
		Collection<Clazz> list = clazzService.search(name);
		ResponseEntity<Collection<Clazz>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Clazz> findOne(@PathVariable("id") Integer id) {
		Clazz clazz = clazzService.findOne(id);
		ResponseEntity<Clazz> result = new ResponseEntity<>(clazz, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<Clazz> save(@RequestBody Clazz clazz) {
		clazzService.save(clazz);
		
		ResponseEntity<Clazz> result = new ResponseEntity<> (HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Clazz> deleteById(@PathVariable("id") Integer id) {
		clazzService.deleteById(id);
		ResponseEntity<Clazz> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/", method=RequestMethod.PUT)
	public ResponseEntity<Clazz> update(@RequestBody Clazz clazz) {
		clazzService.update(clazz);
		ResponseEntity<Clazz> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}	
}
