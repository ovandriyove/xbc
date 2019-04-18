package xbc.service;

import java.util.Collection;
import java.util.Date;

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
	
	@Autowired
	private AuditLogService auditLogService;
	
	@Override
	public Menu findOne(Integer id) {
		return menuDao.findOne(id);
	}
	
	@Override
	public Collection<Menu> findAll() {
		return menuDao.findAll();
	}
	
	//Edit Menu
	@Override
	public Menu update(Menu newMenu) {
		Menu menu = menuDao.findOne(newMenu.getId());
		String jsonBefore = auditLogService.objectToJsonString(menu);
		
		menu.setModifiedBy(1);
		menu.setModifiedOn(new Date());
		menu.setTitle(newMenu.getTitle());
		menu.setDescription(newMenu.getDescription());
		menu.setImageUrl(newMenu.getImageUrl());
		menu.setMenuOrder(newMenu.getMenuOrder());
		menu.setMenuParent(newMenu.getMenuParent());
		menu.setMenuUrl(newMenu.getMenuUrl());
//		menu.setDelete(newMenu.isDelete());
		
		String jsonAfter = auditLogService.objectToJsonString(menu);
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
		menu.setCreateBy(1);
		menu.setCreatedOn(new Date());
		menu.setDelete(false);
//		menu.setCode("1");
		menuDao.save(menu);
		menu.setCode(generateCode(menu.getId()));
		auditLogService.logInsert(auditLogService.objectToJsonString(menu));
		menuDao.update(menu);
	}
	
	@Override
	public Collection<Menu> search(String title) {
		return menuDao.search(title);
	}
	
	@Override
	public Menu softDeleteById(Integer id) {
		Menu menu = menuDao.findOne(id);
		menu.setDeleteBy(1);
		menu.setDeleteOn(new Date());
		menu.setDelete(true);
		auditLogService.logDelete(auditLogService.objectToJsonString(menu));
		return menuDao.update(menu);
	}
	
	private String generateCode(Integer id) {
		String code = "M";
		String angka = String.format("%04d",id);
		return code + angka;
	}
}
