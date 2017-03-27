package com.packt.webstore.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.packt.webstore.domain.Product;

public interface ProductRepository {
	
	List<Product> getAllProducts();
	Product getProductById(String productId);
	List<Product> getProductsByCategory(String category);
	List<Product> getProductByManufacturer(String manufacturer);
	List<Product> getProductByPriceFilter(BigDecimal min, BigDecimal max);
	Set<Product> getProductByFilter(Map<String, List<String>> filterParams);
	void addProduct(Product product);
}
