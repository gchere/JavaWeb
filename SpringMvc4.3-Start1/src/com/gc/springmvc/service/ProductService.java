package com.gc.springmvc.service;

import com.gc.springmvc.domian.Product;

public interface ProductService {
	Product add(Product product);
	Product get(long id);
}
