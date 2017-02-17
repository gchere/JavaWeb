package com.gc.springmvc.domian;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Product {
	private Long id;
	private String name;
	private String description;
	private Double price;
}
