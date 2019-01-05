package com.takahiro310.demospringbootweb.validation.constraints;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.takahiro310.demospringbootweb.validation.TestNameValidator;

@Target(FIELD)
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy={TestNameValidator.class})
public @interface TestName {

	// カスタムバリデーション参考
	// https://ti-tomo-knowledge.hatenablog.com/entry/2018/06/18/094526

	String message() default "{TestForm.name.unused}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@Target({FIELD})
	@Retention(RUNTIME)
	@Documented
	public @interface List {
		TestName[] value();
	}
}
