package xbc.web;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
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
	
//	@RequestMapping(value="/", method=RequestMethod.GET)
//	public ResponseEntity<Collection<Menu>> findAll() {
//		Collection<Menu> list = menuService.findAll();
//		ResponseEntity<Collection<Menu>> result = new ResponseEntity<>(list, HttpStatus.OK);
////		session.setSession("id")=1;
//		return result;
//	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Menu> findOne(@PathVariable("id") Integer id) {
		Menu menu = menuService.findOne(id);
		ResponseEntity<Menu> result = new ResponseEntity<>(menu, HttpStatus.OK);
		return result;
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<Collection<Menu>> search(@RequestParam(value = "title") String title) {
		Collection<Menu> list = menuService.search(title);
		ResponseEntity<Collection<Menu>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<Menu> save(@RequestBody Menu menu) {
//		menu.setCreateBy(session.getSession('id"));
		menuService.save(menu);
		ResponseEntity<Menu> result = new ResponseEntity<> (HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Menu> softDeleteById(@PathVariable("id") Integer id) {
		menuService.softDeleteById(id);
		ResponseEntity<Menu> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/", method=RequestMethod.PUT)
	public ResponseEntity<Menu> update(@RequestBody Menu menu) {
		menuService.update(menu);
		ResponseEntity<Menu> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}
}
