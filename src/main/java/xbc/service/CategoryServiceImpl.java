package xbc.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xbc.dao.CategoryDao;
import xbc.model.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public Category findOne(Integer id) {
		return categoryDao.findOne(id);
	}

	@Override
	public Collection<Category> findAll() {
		return categoryDao.findAll(); 
	}

	@Override
	public Category update(Category newCategory) {
		Category category = categoryDao.findOne(newCategory.getId());
		category.setName(newCategory.getName());
		category.setDescription(newCategory.getDescription());
		category.setModifiedBy(0);
		category.setModifiedOn(new Date());
		return categoryDao.update(category);
	}

	@Override
	public void delete(Category category) {
		categoryDao.delete(category);
	}

	@Override
	public void deleteById(Integer id) {
		categoryDao.deleteById(id);
	}

	@Override
	public void save(Category category) {
		category.setCreatedBy(0);
		category.setCreatedOn(new Date());
		category.setIsDelete(false);
		categoryDao.save(category);
		category.setCode(generateCode(category.getId()));
		categoryDao.update(category);
	}

	// ------------- tambahan
	
	@Override
	public Collection<Category> search(String name) {
		return categoryDao.search(name);
	}
	
	@Override
	public Category softDeleteById(Integer id) {
		Category category = categoryDao.findOne(id);
		category.setDeletedBy(0);
		category.setDeletedOn(new Date());
		category.setIsDelete(true);
		return categoryDao.update(category);
	}

	private String generateCode(Integer id) {
		String code = "C";
		String angka = String.format("%04d", id);
		
		return code + angka;
	}

}
