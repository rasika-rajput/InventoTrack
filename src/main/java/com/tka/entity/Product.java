package com.tka.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int productId;
private String name;
private double price;
private double discountedPrice = 0;
private Long stock;
private String category;
private boolean isDiscountEligible;
public Product() {
	super();
	// TODO Auto-generated constructor stub
}
public Product(int productId, String name, double price, Long stock, String category, boolean isDiscountEligible, double discountedPrice) {
	super();
	this.productId = productId;
	this.name = name;
	this.price = price;
	this.stock = stock;
	this.category = category;
	this.isDiscountEligible = isDiscountEligible;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public Long getStock() {
	return stock;
}
public void setStock(Long stock) {
	this.stock = stock;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public boolean getisDiscountEligible() {
	return isDiscountEligible;
}
public void setisDiscountEligible(boolean isDiscountEligible) {
	this.isDiscountEligible = isDiscountEligible;
}

public double getDiscountedPrice() {
	return discountedPrice;
}
public void setDiscountedPrice(double discountedPrice) {
	this.discountedPrice = discountedPrice;
}

@Override
public String toString() {
	return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", stock=" + stock
			+ ", category=" + category + ", isDiscountEligible=" + isDiscountEligible + "]";
}


}
