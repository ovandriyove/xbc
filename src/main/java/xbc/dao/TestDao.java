package xbc.dao;

import java.util.Collection;

import xbc.model.Test;

public interface TestDao {
	public Collection<Test> findAll();
}
