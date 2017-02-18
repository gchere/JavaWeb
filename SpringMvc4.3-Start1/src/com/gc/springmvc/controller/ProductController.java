package com.gc.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gc.springmvc.domian.Product;
import com.gc.springmvc.form.ProductForm;
import com.gc.springmvc.service.ProductService;

@Controller
public class ProductController {
	private static final Logger logger = Logger.getLogger(ProductController.class);
	
	//自动注入向后端数据库写数据的组件
	@Autowired
	private ProductService productService;
	
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping(value="/product_input")
	public String inputProduct() {
		logger.info("inputProduct 被掉用！ ");
		return "ProductForm";
	}
	@RequestMapping(value="/product_save",method=RequestMethod.POST)
	public String saveProduct(ProductForm productForm ,RedirectAttributes redirectAttributes) {
		logger.info("saveProduct被调用！");
		
		Product product = new Product();
		product.setName(productForm.getName());
		product.setVender(productForm.getVender());
		product.setAddress(productForm.getAddress());
		product.setDescription(productForm.getDescription());
		
		try {
			product.setPrice(Double.parseDouble(productForm.getPrice()));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		//add product
		Product saveProduct = productService.add(product);
		//使用下面的对象。可以重定向传值！
		redirectAttributes.addFlashAttribute("message","the product was successful added!");
		return "redirect:/product_view/"+saveProduct.getId()+".action";
	}
		@RequestMapping(value="product_view/{id}")//{}内的id为路径变量
		public String viewProduct(@PathVariable Long id,Model model){
			Product product = productService.get(id);
			model.addAttribute("product",product);
			return "ProductView";
		}
		@RequestMapping(value="product_retrieve")//{}内的id为路径变量
		public String sendProduct(@RequestParam Long id,Model model){
			Product product = productService.get(id);
			model.addAttribute("product",product);
			return "ProductView";
		}
		
		
		//新建一个现实的action。用来展示所有产品信息。
		@RequestMapping(value="/product_view/product_show")
		public String showPro(Model model){
			List<Product> proList = productService.proShow();
 			model.addAttribute("proList",proList);
			return"ProductList";
		}
		
		//按照id删除产品
		@RequestMapping(value="/product_view/product_del")
		public String del(@RequestParam long id ) {
		 	productService.del(id);
			return "ProductDel";
		}
		
		//修改选中
		@RequestMapping(value="/product_view/product_uping")
		public String  updatePro(@RequestParam long id,Model model){
			Product product = productService.update(id);
			model.addAttribute("product", product);
			return "ProductUp";
		}
		//成功修改
		@RequestMapping(value="/product_view/product_updated" ,method=RequestMethod.POST)
		public String updated(ProductForm productForm ) {
			long id =Long.parseLong(request.getParameter("id"));
			Product product = productService.get(id);
			product.setName(productForm.getName());
			product.setVender(productForm.getVender());
			product.setAddress(productForm.getAddress());
			product.setDescription(productForm.getDescription());
			
			try {
				product.setPrice(Double.parseDouble(productForm.getPrice()));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			
			return "ProductUpdated";
		}
	
}
