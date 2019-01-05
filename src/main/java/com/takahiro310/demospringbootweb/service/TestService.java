package com.takahiro310.demospringbootweb.service;

import java.util.List;
import java.util.Optional;

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

	public Optional<TestBean> findByName(String name) {
		return Optional.ofNullable(testDao.findByName(name));
	}

	public int insert(String name) {
		return testDao.insert(name);
	}

	public int delete(Long id) {
		return testDao.delete(id);
	}
}
