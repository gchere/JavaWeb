package com.gc.springmvc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.omg.PortableServer.POA;
import org.springframework.stereotype.Service;

import com.gc.springmvc.domian.Product;
import com.gc.springmvc.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
	private Map<Long, Product> products = new HashMap<Long,Product>();
	private AtomicLong generator = new AtomicLong();
	
	public  ProductServiceImpl() {
		Product product = new Product();
		product.setName("MiBook");
		product.setDescription("MiBook write code is very cool!");
		product.setPrice(4999.0d);
		add(product);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Product add(Product product) {
		long newid = generator.incrementAndGet();
		product.setId(newid);
		
		//保存到MAP中，此步模拟数据保存到数据库
		products.put(newid, product);
		return product;
	}

	@Override
	public Product get(long id) {
		return products.get(id);
	}
	@Override
	public List<Product> proShow() {
		List<Product> listShow = new ArrayList<Product>(products.values());
		/*Set<Entry<Long, Product>> inSet = new HashSet<Entry<Long, Product>>();
		inSet = products.entrySet();
		Iterator<Entry<Long, Product>> iterator = inSet.iterator();
		for(iterator.hasNext()){
			listShow.add(iterator.next());*/
		return listShow;
		}
	@Override
	public List<Product> del(long id) {
	  	products.remove(id);
	  	List<Product> listShow = new ArrayList<Product>(products.values());
	  	return listShow;
	}
	@Override
	public Product update(long id) {
		Product product = products.get(id);
		return product;
	}
	@Override
	public List<Product> updated(Product product, long id) {
		products.replace(id, product);
		List<Product> listShow = new ArrayList<Product>(products.values());
	  	return listShow;
	}
	
	}


