package com.tka.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Discount 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int disId;
	
private int productId;

@Column(name = "discount_percentage")
private double discountPercentage;
private Date validFrom;
private Date validTo;
private boolean isActive;
public Discount() {
	super();
}
public Discount(int disId, int productId, double discountPercentage, Date validFrom, Date validTo, boolean isActive) {
	super();
	this.disId = disId;
	this.productId = productId;
	this.discountPercentage = discountPercentage;
	this.validFrom = validFrom;
	this.validTo = validTo;
	this.isActive = isActive;
}
public int getDisId() {
	return disId;
}
public void setDisId(int disId) {
	this.disId = disId;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public double getDiscountPercentage() {
	return discountPercentage;
}
public void setDiscountPercentage(double discountPercentage) {
	this.discountPercentage = discountPercentage;
}
public Date getValidFrom() {
	return validFrom;
}
public void setValidFrom(Date validFrom) {
	this.validFrom = validFrom;
}
public Date getValidTo() {
	return validTo;
}
public void setValidTo(Date validTo) {
	this.validTo = validTo;
}
public boolean getisActive() {
	return isActive;
}
public void setisActive(boolean isActive) {
	this.isActive = isActive;
}
@Override
public String toString() {
	return "Discount [disId=" + disId + ", productId=" + productId + ", discountPercentage=" + discountPercentage
			+ ", validFrom=" + validFrom + ", validTo=" + validTo + ", isActive=" + isActive + "]";
}



}
