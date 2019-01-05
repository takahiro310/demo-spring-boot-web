package com.takahiro310.demospringbootweb.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.takahiro310.demospringbootweb.validation.constraints.TestName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestForm {

	@NotBlank
	@Size(max=10)
	@TestName
	private String name;
}
