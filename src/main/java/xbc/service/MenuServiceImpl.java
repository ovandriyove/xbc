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
	public Menu update(Menu newMenu, Integer sessionId) {
		Menu menu = menuDao.findOne(newMenu.getId());
		String jsonBefore = auditLogService.objectToJsonString(menu);
		
		menu.setModifiedBy(sessionId);
		menu.setModifiedOn(new Date());
		menu.setTitle(newMenu.getTitle());
		menu.setDescription(newMenu.getDescription());
		menu.setImageUrl(newMenu.getImageUrl());
		menu.setMenuOrder(newMenu.getMenuOrder());
		menu.setMenuParent(newMenu.getMenuParent());
		menu.setMenuUrl(newMenu.getMenuUrl());
//		menu.setDelete(newMenu.isDelete());
		Menu result = menuDao.update(menu);
		
		String jsonAfter = auditLogService.objectToJsonString(menu);
		return result;
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
	public void save(Menu menu, Integer sessionId) {
		menu.setCreateBy(sessionId);
		menu.setCreatedOn(new Date());
		menu.setDelete(false);
		menuDao.save(menu);
		menu.setCode(generateCode(menu.getId()));
		menuDao.update(menu);
		
		auditLogService.logInsert(auditLogService.objectToJsonString(menu));
		
	}
	
	@Override
	public Collection<Menu> search(String title) {
		return menuDao.search(title);
	}
	
	@Override
	public Menu softDeleteById(Integer id , Integer sessionId) {
		Menu menu = menuDao.findOne(id);
		menu.setDeleteBy(sessionId);
		menu.setDeleteOn(new Date());
		menu.setDelete(true);
		Menu result = menuDao.update(menu);
		auditLogService.logDelete(auditLogService.objectToJsonString(menu));
		return result;
	}
	
	private String generateCode(Integer id) {
		String code = "M";
		String angka = String.format("%04d",id);
		return code + angka;
	}
}
