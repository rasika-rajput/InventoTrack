package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Product;
import com.tka.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController 
{

	@Autowired
    ProductService productService;
	
	@GetMapping("/allProducts")
	public List<Product> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	@GetMapping("/getProductByID/{productId}")
	public Product getProductByID(@PathVariable int productId)
	{
		return productService.getProductByID(productId);
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product product)
	{
		return productService.addProduct(product);
	}
	
	@DeleteMapping("/removeProduct/{productId}")
	public String removeProduct(@PathVariable int productId)
	{
		return productService.removeProduct(productId);
	}
	
	@PutMapping("/updateProduct")
	public String updateProduct(@RequestBody Product product)
	{
		return productService.updateProduct(product);
	}
	
	@GetMapping("/productsOutOfStock")
	public List<Product> productsOutOfStock()
	{
		return productService.productsOutOfStock();
	}
	
	@GetMapping("/productsToRestock")
	public List<Product> productsToRestock()
	{
		return productService.productsToRestock();
	}
	
	@PutMapping("/placeOrder/{productId}/{quantity}")
	public String placeOrder(@PathVariable int productId, @PathVariable int quantity)
	{
		return productService.placeOrder(productId, quantity);
	}
	
	@PutMapping("/updatePriceBasedOnStock")
	public String updatePriceBasedOnStock()
	{
		return productService.updatePriceBasedOnStock();
	}
}
