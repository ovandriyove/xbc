package xbc.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xbc.model.Biodata;
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
	
	@RequestMapping(value="/Search", method=RequestMethod.GET)
	public ResponseEntity<Collection<Biodata>> searchByName(@RequestParam(value = "name") String name) {
		Collection<Biodata> list = biodataService.searchByName(name);
		ResponseEntity<Collection<Biodata>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
}
