package com.packt.webstore.service.impl;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	public List<Product> getProductsByCategory(String category) {
		return productRepository.getProductsByCategory(category);
	}

	public Set<Product> getProductsByFiletr(Map<String, List<String>> filterParams) {
		return productRepository.getProductByFilter(filterParams);
	}

	@Override
	public Product getProductById(String id) {
		return productRepository.getProductById(id);
	}

	@Override
	public List<Product> getProductsByManufacturer(String manufacturer) {
		return productRepository.getProductByManufacturer(manufacturer);
	}

	@Override
	public List<Product> getProductsByPriceFilter(BigDecimal min, BigDecimal max) {
		return productRepository.getProductByPriceFilter(min, max);
	}

	@Override
	public Set<Product> filterProducts(String category, BigDecimal min, BigDecimal max, String manufacturer) {
		Set<Product> filteredProducts = new HashSet<>();
		filteredProducts.addAll(getAllProducts());
		filteredProducts.retainAll(getProductsByCategory(category));
		filteredProducts.retainAll(getProductsByPriceFilter(min, max));
		filteredProducts.retainAll(getProductsByManufacturer(manufacturer));
		return filteredProducts;
	}

	@Override
	public void addProduct(Product product) {
		productRepository.addProduct(product);
		
	}

}
