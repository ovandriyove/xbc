package xbc.service;

import java.util.Collection;

import xbc.model.Biodata;

public interface BiodataService {
	public Biodata findOne(Integer id);
	public Collection<Biodata> findAll();
	public Biodata update(Biodata biodata);
	public void delete(Biodata biodata);
	public void deleteById(Integer id);
	public void save(Biodata biodata);
	public Collection<Biodata> search(String nameOrMajors);
	public Biodata softDeleteById(Integer id);
}
