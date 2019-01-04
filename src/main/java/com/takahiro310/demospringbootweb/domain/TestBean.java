package com.takahiro310.demospringbootweb.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestBean implements Serializable {
	private long id;
	private String name;
}
