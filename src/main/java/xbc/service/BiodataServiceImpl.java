package xbc.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xbc.dao.BiodataDao;
import xbc.model.Biodata;

@Service
@Transactional
public class BiodataServiceImpl implements BiodataService {
	
	@Autowired
	private BiodataDao biodataDao;

	@Override
	public Biodata findOne(Integer id) {
		Biodata result = biodataDao.findOne(id);
		return result;
	}

	@Override
	public Collection<Biodata> findAll() {
		Collection<Biodata> result = biodataDao.findAll();
		return result;
	}

	@Override
	public Biodata update(Biodata biodata) {
		Biodata result = biodataDao.update(biodata);
		return result;
	}

	@Override
	public void delete(Biodata biodata) {
		biodataDao.delete(biodata);
	}

	@Override
	public void deleteById(Integer id) {
		biodataDao.deleteById(id);
	}

	@Override
	public void save(Biodata biodata) {
		biodataDao.save(biodata);
	}

	@Override
	public Collection<Biodata> searchByName(String name) {
		Collection<Biodata> result = biodataDao.searchByName(name);
		return result;
	}

	@Override
	public Collection<Biodata> searchByMajors(String majors) {
		Collection<Biodata> result = biodataDao.searchByMajors(majors);
		return result;
	}
	
	
}
