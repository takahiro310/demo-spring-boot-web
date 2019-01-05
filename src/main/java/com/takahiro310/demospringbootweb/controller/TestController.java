package com.takahiro310.demospringbootweb.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.takahiro310.demospringbootweb.controller.form.TestForm;
import com.takahiro310.demospringbootweb.domain.TestBean;
import com.takahiro310.demospringbootweb.service.TestService;

@Controller
@RequestMapping(value="test")
public class TestController {

	private final static Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	private TestService testService;

	@GetMapping("list")
	public ModelAndView testList(ModelAndView mav) {
		List<TestBean> testList = testService.selectAll();
		mav.addObject("testList", testList);
	    mav.setViewName("test-list");
	    return mav;
	}

	@GetMapping("new")
    public String testNew(@ModelAttribute("testForm") TestForm form) {
        return "test-new";
    }

	@PostMapping("create")
	public String testCreate(@ModelAttribute("testForm") @Valid TestForm form, BindingResult result) {

		if (result.hasErrors()) {
			for(FieldError err: result.getFieldErrors()) {
				logger.debug("error code = [" + err.getCode() + "]");
			}
			return "test-new";
		}

		testService.insert(form.getName());
		return "redirect:/test/list";
	}

	@DeleteMapping("{id}")
	public String testDestroy(@PathVariable Long id) {
		testService.delete(id);
		return "redirect:/test/list";
	}

}
