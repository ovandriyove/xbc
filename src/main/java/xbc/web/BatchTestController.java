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
import org.springframework.web.bind.annotation.RestController;

import xbc.model.BatchTest;
import xbc.modelview.BatchTestView;
import xbc.service.BatchTestService;

@RestController
@RequestMapping("/batchTest")
public class BatchTestController {
	
	@Autowired
	private BatchTestService batchTestService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<Collection<BatchTest>> findAll() {
		Collection<BatchTest> list = batchTestService.findAll();
		ResponseEntity<Collection<BatchTest>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<BatchTest> findOne(@PathVariable("id") Integer id) {
		BatchTest batchTest = batchTestService.findOne(id);
		ResponseEntity<BatchTest> result = new ResponseEntity<>(batchTest, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<BatchTest> save(@RequestBody BatchTestView batchTestView, HttpSession session) {
		batchTestService.save(batchTestView, (int) session.getAttribute("sessionId"));
		ResponseEntity<BatchTest> result = new ResponseEntity<> (HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/", method=RequestMethod.PUT)
	public ResponseEntity<BatchTest> update(@RequestBody BatchTest batchTest) {
		batchTestService.update(batchTest);
		ResponseEntity<BatchTest> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}	
}
