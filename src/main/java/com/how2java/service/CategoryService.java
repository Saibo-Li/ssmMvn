package com.how2java.service;

import java.util.List;

import com.how2java.pojo.Category;
import com.how2java.util.Page;

public interface CategoryService {
	List<Category> list();
	int total();
	void add(Category c);
	void update(Category c);
	void delete(Category c);
	Category get(int id);
}
