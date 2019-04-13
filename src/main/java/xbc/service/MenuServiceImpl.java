package xbc.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xbc.dao.MenuDao;
import xbc.model.Menu;

@Service
@Transactional
public class MenuServiceImpl  implements MenuService {
	
	@Autowired
	private MenuDao menuDao;
	
	@Override
	public Menu findOne(Integer id) {
		return menuDao.findOne(id);
	}
	
	@Override
	public Collection<Menu> findAll() {
		return menuDao.findAll();
	}

	@Override
	public Menu update(Menu menu) {
		return menuDao.update(menu);
	}
	
	@Override
	public void delete(Menu menu) {
		menuDao.delete(menu);
	}
	
	@Override
	public void deleteById(Integer id) {
		menuDao.deleteById(id);
	}
	
	@Override
	public void save(Menu menu) {
		menuDao.save(menu);
	}
	
	@Override
	public Collection<Menu> searchByTitle(String title) {
		return menuDao.searchByTitle(title);
	}
}
