package com.takahiro310.demospringbootweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.takahiro310.demospringbootweb.controller.form.SimpleRestBean;
import com.takahiro310.demospringbootweb.domain.TestBean;
import com.takahiro310.demospringbootweb.service.TestService;


@RestController
@EnableAutoConfiguration
public class SimpleRestController {

	private final static Logger logger = LoggerFactory.getLogger(SimpleRestController.class);

	@Autowired
	private TestService testService;

	@GetMapping(value="/simple-rest01")
	public String simpleRest01() {
		return "simple-rest01";
	}

	@RequestMapping("/simple-rest02")
	public List<SimpleRestBean> simpleRest02() {
		List<SimpleRestBean> list = new ArrayList<SimpleRestBean>();
		SimpleRestBean bean = new SimpleRestBean();
		bean.setName("AAA");
		bean.setValue("これは");
		list.add(bean);

		bean = new SimpleRestBean();
		bean.setName("BBB");
		bean.setValue("テスト");
		list.add(bean);

		bean = new SimpleRestBean();
		bean.setName("CCC");
		bean.setValue("です");
		list.add(bean);
		return list;
	}

	@GetMapping("/simple-rest03")
	public String simpleRest03(@RequestParam("param") String param) {
		logger.debug(param);
		return "Hello!, " + param;
	}

	@RequestMapping(value="/simple-rest04", consumes=MediaType.APPLICATION_JSON_VALUE)
	public SimpleRestBean simpleRest04(@RequestBody SimpleRestBean bean) {
		logger.debug(bean.getName());
		return bean;
	}

	@GetMapping("simple-rest05")
	public List<TestBean> simpleRest05() {
		List<TestBean> list = testService.selectAll();
		return list;
	}
}
