package xbc.service;

import java.util.Collection;

import xbc.model.Category;

public interface CategoryService {

	public Collection<Category> findAll();
	public Category findOne(Integer id);
	public void delete(Category category);
	public void deleteById(Integer id);
	public Category update(Category category);
	public void save(Category category);

	// ------------- tambahan
	
	public Collection<Category> search(String name);
	public Category softDeleteById(Integer id);
}
