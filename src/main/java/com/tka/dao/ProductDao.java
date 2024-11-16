package com.tka.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Product;

@Repository
public class ProductDao 
{
	@Autowired
    public SessionFactory sessionFactory;
	
	
	public List<Product> getAllProducts() 
	{
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Product.class);
		List<Product> products = criteria.list(); 
		
		session.close();
		return products;
	}

	public Product getProductByID(int productId) 
	{
		Session session = sessionFactory.openSession();
		Product product = session.get(Product.class, productId);
		
		return product;
	}

	public String addProduct(Product product) 
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(product);
		transaction.commit();
		session.close();
		
		return "Product Added Successfully";
	}

	public boolean removeProduct(int productId) 
	{
		boolean flag = false;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Product product = session.get(Product.class, productId);
		
		if(product != null)
		{
			session.delete(product);
			flag = true;
		}
		transaction.commit();
		session.close();
		
		return flag;
	}

	public String updateProduct(Product product) 
	{
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(product);
        
		transaction.commit();
	    session.close();
		return "Product Updated Successfully";
		
	}

	public List<Product> productsOutOfStock() 
	{
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Product.class);
		List<Product> products = criteria.list(); 
		
		List<Product> outOfStock = new ArrayList();
				
		for (Product product : products) 
		{
			if(product.getStock() < 10)
			{
				outOfStock.add(product);
			}
		}
		return outOfStock;
	}
	
	public List<Product> productsToRestock() 
	{
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Product.class);
		List<Product> products = criteria.list(); 
		
		List<Product> reStock = new ArrayList();
				
		for (Product product : products) 
		{
			if(product.getStock() < 20)
			{
				reStock.add(product);
			}
		}
		return reStock;
	}

	public String placeOrder(int productId, int quantity) 
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Product product = session.get(Product.class, productId);
		double bill;
		double discountedBill;
		 bill = product.getPrice() * quantity;
		if(quantity >= 100)
		{
			discountedBill = bill - (bill * 10/100);
			return "Total Bill After Discount of 10%  =  Rs." +discountedBill;
		}
		else
		{
			return "Total Bill =  Rs." +bill;
		}
	}

	public String updatePriceBasedOnStock() 
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Product> allProducts = getAllProducts();
		List<Product> updatedProducts = new ArrayList();
		double updatedPrice;
		String msg = null;
		
		for (Product product : allProducts) 
		{
			if(product.getStock() >= 1000)
			{
			    updatedPrice = product.getPrice() - (product.getPrice()*5/100);
				product.setPrice(updatedPrice);
				session.update(product);
				updatedProducts.add(product);
				msg = "Reduced The Price for Product " +product.getName() +" by 5%  =  Rs." +product.getPrice();
			}
			
			 if(product.getStock() < 50)
			{
			    updatedPrice = product.getPrice() + (product.getPrice()*5/100);
				product.setPrice(updatedPrice);
				session.update(product);
				updatedProducts.add(product);
				msg = "Increased The Price for Product " +product.getName() +" by 5%  =  Rs." +product.getPrice();
			}
		}
		transaction.commit();
		session.close();
		return msg;
	}
	
	public List<Integer> discountEligible()
	{
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Product.class);
		criteria.add(Restrictions.eq("isDiscountEligible", true));
		
        criteria.setProjection(Projections.property("id"));
        
        List<Integer> eligibleProductId = criteria.list();
        
        return eligibleProductId;
	}
	}


