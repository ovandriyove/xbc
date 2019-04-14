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

import xbc.model.Biodata;
import xbc.model.Menu;
import xbc.service.BiodataService;

@RestController
@RequestMapping("/biodata")
public class BiodataController {
	
	@Autowired
	private BiodataService biodataService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<Collection<Biodata>> findAll() {
		Collection<Biodata> list = biodataService.findAll();
		ResponseEntity<Collection<Biodata>> result = new ResponseEntity<> (list, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Biodata> findOne(@PathVariable("id") Integer id) {
		Biodata biodata = biodataService.findOne(id);
		ResponseEntity<Biodata> result = new ResponseEntity<>(biodata, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public ResponseEntity<Collection<Biodata>> searchByName(@RequestParam(value = "name") String name) {
		Collection<Biodata> list = biodataService.searchByName(name);
		ResponseEntity<Collection<Biodata>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public ResponseEntity<Collection<Biodata>> searchByMajors(@RequestParam(value="majors") String majors) {
		Collection<Biodata> list = biodataService.searchByMajors(majors);
		ResponseEntity<Collection<Biodata>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<Biodata> save(@RequestBody Biodata biodata) {
//		biodata.setCreateBy(session.getSession('id"));
		biodataService.save(biodata);
		ResponseEntity<Biodata> result = new ResponseEntity<> (HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Biodata> deleteById(@PathVariable("id") Integer id) {
		biodataService.deleteById(id);
		ResponseEntity<Biodata> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/", method=RequestMethod.PUT)
	public ResponseEntity<Biodata> update(@RequestBody Biodata biodata) {
		ResponseEntity<Biodata> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}	
}
