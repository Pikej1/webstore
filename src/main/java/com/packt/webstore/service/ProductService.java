package com.packt.webstore.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.packt.webstore.domain.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	List<Product> getProductsByCategory(String category);
	List<Product> getProductsByManufacturer(String manufacturer);
	List<Product> getProductsByPriceFilter(BigDecimal min, BigDecimal max);
	Set<Product> getProductsByFiletr(Map<String, List<String>> filterParams);
	Set<Product> filterProducts(String category, BigDecimal min, BigDecimal max, String manufacturer);
	Product getProductById(String id);
	void addProduct(Product product);
}
