package xbc.web;

import java.util.Collection;
import java.util.Date;

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

import xbc.model.Batch;
import xbc.model.Trainer;
import xbc.service.BatchService;

@RestController
@RequestMapping("/batch")
public class BatchController {
	
	@Autowired
	private BatchService batchService;
	
	@RequestMapping(value="/findAll", method=RequestMethod.GET)
	public ResponseEntity<Collection<Batch>> findAll() {
		Collection<Batch> list = batchService.findAll();
		ResponseEntity<Collection<Batch>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<Collection<Batch>> search(@RequestParam(value = "name") String name) {
		Collection<Batch> list = batchService.search(name);
		ResponseEntity<Collection<Batch>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Batch> findOne(@PathVariable("id") Integer id) {
		Batch batch = batchService.findOne(id);
		ResponseEntity<Batch> result = new ResponseEntity<>(batch, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<String> save(@RequestBody Batch batch, HttpSession session) {
		if (batchService.checkDuplicate(batch.getName(), batch.getId())) {
			ResponseEntity<String> result = new ResponseEntity<>("Batch name yang sama sudah terdaftar", HttpStatus.CONFLICT);
			return result;
		} else {
			batchService.save(batch, (Integer) session.getAttribute("sessionId"));
			ResponseEntity<String> result = new ResponseEntity<>("OK", HttpStatus.OK);
			return result;
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Batch> softDeleteById(@PathVariable("id") Integer id, HttpSession session) {
		batchService.softDeleteById(id, (int) session.getAttribute("sessionId"));
		ResponseEntity<Batch> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}
	
//	@RequestMapping(value="/", method=RequestMethod.PUT)
//	public ResponseEntity<Batch> update(@RequestBody Batch batch, HttpSession session) {
//		batchService.update(batch, (Integer) session.getAttribute("sessionId"));
//		ResponseEntity<Batch> result = new ResponseEntity<>(HttpStatus.OK);
//		return result;
//	}
	
	@RequestMapping(value="/", method=RequestMethod.PUT)
	public ResponseEntity<String> update(@RequestBody Batch batch, HttpSession session) {
		if (batchService.checkDuplicate(batch.getName(), batch.getId())) {
			ResponseEntity<String> result = new ResponseEntity<>("Test name yang sama sudah terdaftar", HttpStatus.CONFLICT);
			return result;
		} else {
			batchService.update(batch, (Integer) session.getAttribute("sessionId"));
			ResponseEntity<String> result = new ResponseEntity<>("OK", HttpStatus.OK);
			return result;
		}
	}
	
	@RequestMapping(value="/trainer-tersedia/", method=RequestMethod.GET)
	public ResponseEntity<Collection<Trainer>> trainerTersedia(
			@RequestParam(value = "periodFromSekarang") Date periodFromSekarang, 
			@RequestParam(value = "periodToSekarang") Date periodToSekarang) {
		Collection<Trainer> list = batchService.trainerTersedia(periodFromSekarang, periodToSekarang);
		ResponseEntity<Collection<Trainer>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
}
