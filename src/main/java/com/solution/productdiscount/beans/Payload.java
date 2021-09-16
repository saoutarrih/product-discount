package com.solution.productdiscount.beans;

import java.util.List;

public class Payload {
	
	List<Product> products;

	public Payload() {

	}
	
	public Payload(List<Product> products) {
		super();
		this.products = products;
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
