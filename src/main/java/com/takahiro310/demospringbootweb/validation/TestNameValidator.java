package com.takahiro310.demospringbootweb.validation;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.takahiro310.demospringbootweb.domain.TestBean;
import com.takahiro310.demospringbootweb.service.TestService;
import com.takahiro310.demospringbootweb.validation.constraints.TestName;

public class TestNameValidator implements ConstraintValidator<TestName, String> {

	@Autowired
	private TestService testService;

	public void initialize(TestName constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		Optional<TestBean> testOpt = testService.findByName(value);
		return !testOpt.isPresent();
	}

}
