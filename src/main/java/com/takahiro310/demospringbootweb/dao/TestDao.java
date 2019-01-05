package com.takahiro310.demospringbootweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.takahiro310.demospringbootweb.domain.TestBean;

@Repository
public interface TestDao {

	List<TestBean> selectAll();

	TestBean findByName(String name);

	int insert(String name);

	int delete(Long id);
}
