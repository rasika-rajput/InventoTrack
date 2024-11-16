package com.tka.entity;

import javax.persistence.*;

import java.sql.Date;

@Entity
public class Sales 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salesId;

    private int productId;
    private int disId; 
    private double totalPrice;
    private int quantity;
    private int month;
    private int year;
    private Date purchaseDate;

    public Sales() {}

    public Sales(int productId, int disId, double totalPrice, int quantity, Date purchaseDate, int month, int year) {
        this.productId = productId;
        this.disId = disId;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
    }

    public int getSalesId() {
        return salesId;
    }

    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getDisId() {
        return disId;
    }

    public void setDisId(int disId) {
        this.disId = disId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
    
    
}

