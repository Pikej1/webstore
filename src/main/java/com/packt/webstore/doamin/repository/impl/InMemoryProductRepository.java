package com.packt.webstore.doamin.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;
import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.exception.ProductNotFoundException;

@Repository
public class InMemoryProductRepository implements ProductRepository{
	
	private List<Product> listOfProducts = new ArrayList<>();
	
	public InMemoryProductRepository(){
		Product iphone = new Product("P1234","iPhone 5s", new BigDecimal(500));
		iphone.setDescription("Apple iPhone 5s, smartfon z 4-calowym ekranemo rozdzielczości 640x1136 i 8-megapikselowym aparatem");
		iphone.setCategory("Smartfon");
		iphone.setManufacturer("Apple");
		iphone.setUnitsInStock(1000);
		iphone.setImgUrl("https://0.allegroimg.com/s400/015a46/1c0334064d38bbde4b027a3baa50");
		Product laptop_dell = new Product("P1235","Dell Inspiron", new BigDecimal(700));
		laptop_dell.setDescription("Dell Inspiron, 14-calowy laptop (czarny) z procesorem Intel Core 3. generacji");
		laptop_dell.setCategory("Laptop");
		laptop_dell.setManufacturer("Dell");
		laptop_dell.setUnitsInStock(1000);
		laptop_dell.setImgUrl("http://photos.maxim-development.eu/albums/userpics/10001/71-mo7HdlHL__SL1500_.jpg");
		Product tablet_Nexus = new Product("P1236","Nexus 7", new BigDecimal(300));
		tablet_Nexus.setDescription("Google Nexus 7 jest najlżejszym 7-calowym tabletem "
				+ "z 4-rdzeniowym procesorem Qualcomm Snapdragon™ S4 Pro");
		tablet_Nexus.setCategory("Tablet");
		tablet_Nexus.setManufacturer("Google");
		tablet_Nexus.setUnitsInStock(1000);
		tablet_Nexus.setImgUrl("http://www.letsgodigital.org/images/artikelen/234/nexus-7-tablet.jpg");
		listOfProducts.add(iphone);
		listOfProducts.add(laptop_dell);
		listOfProducts.add(tablet_Nexus);
	}
	public List<Product> getAllProducts() {
		return listOfProducts;
	}
	
	public Product getProductById(String productId){
		Product productById = null;
		for(Product product: listOfProducts){
			if(product != null && product.getProductId() != null && product.getProductId().equals(productId)){
				productById = product;
				break;
			}
		}
		if(productById == null){
			//throw new IllegalArgumentException("Brak produktu o wskazanym id: "+productId);
			throw new ProductNotFoundException(productId);
		}
		return productById;
	}
	
	public List<Product> getProductsByCategory(String category) {
		List<Product> productByCategory = new ArrayList<>();
		for(Product product: listOfProducts){
			if(product.getCategory().equalsIgnoreCase(category)) productByCategory.add(product);
		}
		return productByCategory;
	}

	public Set<Product> getProductByFilter(Map<String, List<String>> filterParams) {
		Set<Product> productsByBrand = new HashSet<Product>();
		Set<Product> productsByCategory = new HashSet<Product>();
		Set<String> criterias = filterParams.keySet();
		if(criterias.contains("brand")){
			for(String brandName: filterParams.get("brand")){
				for(Product product: listOfProducts){
					if(brandName.equalsIgnoreCase(product.getManufacturer())){
						productsByBrand.add(product);
					}
				}
			}
		}
		if(criterias.contains("category")){
			for(String category: filterParams.get("category")){
				productsByCategory.addAll(this.getProductsByCategory(category));
			}
		}
		productsByCategory.retainAll(productsByBrand);
		return productsByCategory;
	}
	@Override
	public List<Product> getProductByManufacturer(String manufacturer) {
		List<Product> productsByManufacturer = new ArrayList<>();
		for(Product product: listOfProducts){
			if(manufacturer.equalsIgnoreCase(product.getManufacturer()))
				productsByManufacturer.add(product);
		}
		return productsByManufacturer;
	}
	@Override
	public List<Product> getProductByPriceFilter(BigDecimal min, BigDecimal max) {
		List<Product> productsByPriceFilter = new ArrayList<>();
		for(Product product: listOfProducts){
			if(product.getUnitPrice().compareTo(min) >=0 && product.getUnitPrice().compareTo(max) < 0)
				productsByPriceFilter.add(product);
		}
		return productsByPriceFilter;
	}
	@Override
	public void addProduct(Product product) {
		listOfProducts.add(product);
		
	}
}
