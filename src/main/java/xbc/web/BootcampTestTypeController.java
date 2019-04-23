package xbc.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xbc.model.BootcampTestType;
import xbc.service.BootcampTestTypeService;

@RestController
@RequestMapping("/bootcampTestType")
public class BootcampTestTypeController {

	@Autowired
	private BootcampTestTypeService bootcampTestTypeService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<Collection<BootcampTestType>> findAll() {
		Collection<BootcampTestType> list = bootcampTestTypeService.findAll();
		ResponseEntity<Collection<BootcampTestType>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
}
