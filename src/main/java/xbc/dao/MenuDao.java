package xbc.dao;

import java.util.Collection;

import xbc.model.Menu;

public interface MenuDao {
	public Menu findOne(long id);
	public Collection<Menu> findAll();
	public Menu update(Menu menu);
	public void delete(Menu menu);
	public void deleteById(long id);
	public void save(Menu menu);
	public Collection<Menu> searchByTitle(String title);
}
