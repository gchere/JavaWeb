package com.gc.springmvc.service;

import java.util.List;

import com.gc.springmvc.domian.Product;

public interface ProductService {
	Product add(Product product);
	Product get(long id);
	List<Product> proShow();
	List<Product> del(long id);
	Product update(long id);
	List<Product> updated(Product product ,long id);
}
