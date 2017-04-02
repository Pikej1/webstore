package com.packt.webstore.domain;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

@XmlRootElement
public class Product {
	private String productId;
	private String name;
	private BigDecimal unitPrice;
	private String description;
	private String manufacturer;
	private String category;
	private long unitsInStock;
	private long unitInOrder;
	private boolean discontinued;
	private String condition;
	private String imgUrl;
	@JsonIgnore
	private MultipartFile productImage;
	
	public Product(){
		super();
	}
	
	public Product(String productId, String name, BigDecimal unitPrice){
		this.productId = productId;
		this.name = name;
		this.unitPrice = unitPrice;
	}
	
	public void setProductId(String id){
		productId = id;
	}
	public String getProductId(){
		return productId;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	public void setUnitPrice(BigDecimal price){
		unitPrice = price;
	}
	public BigDecimal getUnitPrice(){
		return unitPrice;
	}
	
	public void setDescription(String d){
		description = d;
	}
	public String getDescription(){
		return description;
	}
	
	public void setManufacturer(String man){
		manufacturer = man;
	}
	public String getManufacturer(){
		return manufacturer;
	}
	
	public void setCategory(String cat){
		category = cat;
	}
	public String getCategory(){
		return category;
	}

	public long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public long getUnitInOrder() {
		return unitInOrder;
	}

	public void setUnitInOrder(long unitInOrder) {
		this.unitInOrder = unitInOrder;
	}

	public boolean isDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	@XmlTransient
	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	
	@Override
	public boolean equals(Object obj){
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		
		Product other = (Product) obj;
		if(productId == null){
			if(other.productId != null)
				return false;
		}else if(!productId.equals(other.productId))
			return false;
		return true;
	}
	
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		return result;
	}
	
	@Override
	public String toString(){
		return "Product [productId=" + productId + ", nazwa=" + name + "]"; 
	}


}
