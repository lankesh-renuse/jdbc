package com.sit.dao;

import java.util.List;

public interface DAO <T> {
	void save(T s);
	void update(int id, double salary);
	void delete(int id);
	List<T> fetch();
}
