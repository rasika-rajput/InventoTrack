package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.tka.dao.DiscountDao;
import com.tka.dao.ProductDao;
import com.tka.entity.Discount;
import com.tka.entity.Product;

@Service
public class DiscountService 
{
	@Autowired
	DiscountDao discountDao;
	
	public List<Discount> allDiscounts() 
	{
		return discountDao.allDiscounts();
	}
	
	public String addDiscount(Discount dis) 
	{
		return discountDao.addDiscount(dis);
	}
	
	public List<Discount> allActiveDiscounts() 
	{
		return discountDao.allActiveDiscounts();
	}
	
	public String applySeasonalDiscounts(Float discountPercentage) 
	{
		return discountDao.applySeasonalDiscounts(discountPercentage);
	}

	
}
