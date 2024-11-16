package com.tka.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.tka.entity.Discount;
import com.tka.entity.Product;
import com.tka.entity.Sales;

@Repository
public class DiscountDao 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	SalesDao salesDao;
	
	public List<Discount> allDiscounts() 
	{
      Session session = sessionFactory.openSession();
      Criteria criteria = session.createCriteria(Discount.class);
      List<Discount> discounts = criteria.list();
      
      return discounts;
	}

	public String addDiscount(Discount dis) 
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(dis);
		transaction.commit();
		session.close();
		
		return "Discount Added Successfully...!!!";
	}

	public List<Discount> allActiveDiscounts() 
	{
		Session session = sessionFactory.openSession();
	      Criteria criteria = session.createCriteria(Discount.class);
	      List<Discount> discounts = criteria.list();
	      
	      List<Discount> activeDiscounts = new ArrayList();
	      for (Discount discount : discounts) 
	      {
			if(discount.getisActive() == true)
			{
				activeDiscounts.add(discount);
			}
		}
	      
	      return activeDiscounts;
	}

	public String applySeasonalDiscounts(Float discountPercentage) 
	{
		List<Product> allProducts = productDao.getAllProducts();
		for (Product product : allProducts) 
		{
			if(product.getisDiscountEligible() == true)
			{
				if (product != null) 
	            {
					
	                double discountedPrice = product.getPrice() - (product.getPrice() * (discountPercentage / 100));
	                product.setDiscountedPrice(discountedPrice);
	                productDao.updateProduct(product);
	                
	            }
			}
		}
		 return "Discount Applied Successfully...!!!";
	}
	
	
}
