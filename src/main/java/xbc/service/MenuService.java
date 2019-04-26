package xbc.service;

import java.util.Collection;

import xbc.model.Menu;

public interface MenuService {
	public Menu findOne(Integer id);
	public Collection<Menu> findAll();
	public Menu update(Menu menu, Integer sessionId);
	public void delete(Menu menu);
	public void deleteById(Integer id);
	public void save(Menu menu, Integer sessionId);
	public Collection<Menu> search(String title);
	public Menu softDeleteById(Integer id, Integer sessionId);
}
