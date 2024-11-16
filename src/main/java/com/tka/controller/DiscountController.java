package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Discount;
import com.tka.service.DiscountService;

@RestController
@RequestMapping("/discounts")
public class DiscountController 
{
	@Autowired
    DiscountService discountService;
	
	@GetMapping("/allDiscounts")
	public List<Discount> allDiscounts()
	{
		return discountService.allDiscounts();
	}
	
	@PostMapping("/addDiscount")
	public String addDiscount(@RequestBody Discount dis)
	{
		return discountService.addDiscount(dis);
	}
	
	@GetMapping("/allActiveDiscounts")
	public List<Discount> allActiveDiscounts()
	{
		return discountService.allActiveDiscounts();
	}
	
	@PutMapping("/applySeasonalDiscounts/{discountPercentage}")
	public String applySeasonalDiscounts(@PathVariable Float discountPercentage)
	{
		return discountService.applySeasonalDiscounts(discountPercentage);
	}
	
	
}
