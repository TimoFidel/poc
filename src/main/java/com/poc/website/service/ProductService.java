package com.poc.website.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.website.model.Product;
import com.poc.website.model.Vendor;
import com.poc.website.repository.ProductRepository;
import com.poc.website.repository.VendorRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	VendorRepository vendorRepository;
	
	public Product getProductById(long id) {
		return productRepository.getById(id);
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public void deleteProduct(long id) {
		productRepository.deleteById(id);
	}
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	public Product addProduct(long id, Product product) {
		Vendor vendor= vendorRepository.getById(id);
		product.setVendor(vendor);
		return productRepository.save(product);
	}
	

}
