package com.how2java.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

	@Autowired
	private CategoryMapper categoryMapper;
	public List<Category> list(){
		return categoryMapper.list();
	}
	public void deleteAll() {
		List<Category> cs = list();
		for (Category c : cs) {

			categoryMapper.delete(c.getId());
		}
	}

	@Test
	public void testList() {
		PageHelper.offsetPage(0, 5);
		List<Category> cs=categoryMapper.list();
		System.out.println(cs.getClass());
		for (Category c : cs) {
			System.out.println(c.getName());
		}
		System.out.println(new PageInfo(cs).getTotal());
	}
	@Test
	public void addTwo() {

		Category c1 = new Category();
		c1.setName("短的名字");
		categoryMapper.add(c1);

		Category c2 = new Category();
		c2.setName("名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,");
		categoryMapper.add(c2);
	}
}
