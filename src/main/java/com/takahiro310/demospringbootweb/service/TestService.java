package com.takahiro310.demospringbootweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.takahiro310.demospringbootweb.dao.TestDao;
import com.takahiro310.demospringbootweb.domain.TestBean;

@Service
public class TestService {

	@Autowired
	private TestDao testDao;

	public List<TestBean> selectAll() {
		return testDao.selectAll();
	}
}
