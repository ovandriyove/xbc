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

import xbc.model.Menu;
import xbc.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<Collection<Menu>> findAll() {
		Collection<Menu> list = menuService.findAll();
		ResponseEntity<Collection<Menu>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Menu> findOne(@PathVariable("id") long id) {
		Menu menu = menuService.findOne(id);
		ResponseEntity<Menu> result = new ResponseEntity<>(menu, HttpStatus.OK);
		return result;
	}
	
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public ResponseEntity<Collection<Menu>> searchByTitle(@RequestParam(value = "title") String title) {
		Collection<Menu> list = menuService.searchByTitle(title);
		ResponseEntity<Collection<Menu>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Menu> deleteById(@PathVariable("id") long id) {
		menuService.deleteById(id);
		ResponseEntity<Menu> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/", method=RequestMethod.PUT)
	public ResponseEntity<Menu> update(@RequestBody Menu menu) {
		ResponseEntity<Menu> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}
}
