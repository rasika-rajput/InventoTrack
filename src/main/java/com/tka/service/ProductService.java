package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.ProductDao;
import com.tka.entity.Product;

@Service
public class ProductService 
{

	@Autowired
	ProductDao productDao;
	public List<Product> getAllProducts() 
	{
		return productDao.getAllProducts();
	}
	
	public Product getProductByID(int productId) 
	{
		return productDao.getProductByID(productId);
	}
	
	public String addProduct(Product product) 
	{
		return productDao.addProduct(product);
	}
	
	public String removeProduct(int productId)
	{
		boolean flag = productDao.removeProduct(productId);
		if(flag)
		{
			return "Product Removed Successfully...!!!";
		}
		else
		{
			return "Product Not Found With ID : " +productId;
		}
	}
	
	public String updateProduct(Product product) 
	{
		return productDao.updateProduct(product);
	}
	
	public List<Product> productsOutOfStock() 
	{
		return productDao.productsOutOfStock();
	}
	
	public List<Product> productsToRestock() 
	{
		return productDao.productsToRestock();
	}

	public String placeOrder(int productId, int quantity)
	{
		return productDao.placeOrder(productId, quantity);
	}

	public String updatePriceBasedOnStock() 
	{
		return productDao.updatePriceBasedOnStock();
	}
}
