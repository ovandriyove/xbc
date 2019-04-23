package xbc.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xbc.model.BootcampType;
import xbc.service.BootcampTypeService;

@RestController
@RequestMapping("/bootcampType")
public class BootcampTypeController {
	
	@Autowired
	private BootcampTypeService bootcampTypeService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<Collection<BootcampType>> findAll() {
		Collection<BootcampType> list = bootcampTypeService.findAll();
		ResponseEntity<Collection<BootcampType>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
}
