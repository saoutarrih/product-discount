package com.solution.productdiscount.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.solution.productdiscount.beans.Discount;
import com.solution.productdiscount.beans.Payload;
import com.solution.productdiscount.services.ProductDiscountService;

@RestController
public class ProductDiscountController {
	
	@Autowired
	ProductDiscountService productDiscountService;

	@PostMapping("/promotions")
	public List<Discount> recieveProducts(@RequestBody Payload payload){

		return productDiscountService.calculatePromotions(payload);
	}


}
