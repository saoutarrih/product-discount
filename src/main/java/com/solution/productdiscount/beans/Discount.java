package com.solution.productdiscount.beans;

public class Discount {
	
	String id;
    long quantity;
    
	public Discount() {

	}

	public Discount(String id, long quantity) {
		this.id = id;
		this.quantity = quantity;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
 

}
