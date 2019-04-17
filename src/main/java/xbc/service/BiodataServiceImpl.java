package xbc.service;

import java.util.Collection;
import java.util.Date;

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
		return biodataDao.findOne(id);
	}

	@Override
	public Collection<Biodata> findAll() {
		return biodataDao.findAll();
	}

	@Override
	public Biodata update(Biodata newBiodata) {
		Biodata biodata = biodataDao.findOne(newBiodata.getId());
		biodata.setModifiedBy(1);
		biodata.setModifiedOn(new Date());
		biodata.setGender(newBiodata.getGender());
		biodata.setBootcampTestType(newBiodata.getBootcampTestType());
		biodata.setIq(newBiodata.getId());
		biodata.setDu(newBiodata.getDu());
		biodata.setNestedLogic(newBiodata.getNestedLogic());
		biodata.setArithmetic(newBiodata.getArithmetic());
		biodata.setTro(newBiodata.getTro());
		biodata.setInterviewer(newBiodata.getInterviewer());
		biodata.setNotes(newBiodata.getNotes());
		return biodataDao.update(biodata);
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
		biodata.setCreateBy(1);
		biodata.setCreatedOn(new Date());
		biodata.setDelete(false);
		biodataDao.save(biodata);
	}

	@Override
	public Collection<Biodata> search(String nameOrMajors) {
		return biodataDao.search(nameOrMajors);
	}
	
	@Override 
	public Biodata softDeleteById(Integer id) {
		Biodata biodata = biodataDao.findOne(id);
		biodata.setDeleteBy(1);
		biodata.setDeleteOn(new Date());
		biodata.setDelete(true);
		return biodataDao.update(biodata);
	}
}
