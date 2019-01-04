package com.takahiro310.demospringbootweb.dao;

import java.util.List;

import com.takahiro310.demospringbootweb.domain.TestBean;

public interface TestDao {

	List<TestBean> selectAll();
}
