package com.poc.website.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.website.model.Product;
import com.poc.website.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable long id) {
		return productService.getProductById(id);
	}
	@PostMapping("/")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable long id) {
		productService.deleteProduct(id);
	}
	@GetMapping("/allProduct")
	public List<Product> getAllProduct(){
		return productService.getAllProduct();
	}
	@PostMapping("/addProduct/{id}")
	public Product addProduct(@PathVariable long id,@RequestBody Product product) {
		return productService.addProduct(id, product);
	}
	

}
