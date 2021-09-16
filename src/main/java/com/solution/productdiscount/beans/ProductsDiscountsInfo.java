package com.solution.productdiscount.beans;

import java.util.List;

public class ProductsDiscountsInfo {
	
	boolean hasProductA;
	long totalProductsBandC;
	long totalProductD;
	List<Discount> listDiscounts;

	public void increaseDiscountX(long value) {
		
			for(Discount discount : listDiscounts) {
				if(discount.getId().equals("X")) {
					discount.setQuantity(discount.getQuantity()+value);
					break;
				}
			}	
	}
	
	public void increaseDiscountY(long value) {
		
		for(Discount discount : listDiscounts) {
			if(discount.getId().equals("Y")) {
				discount.setQuantity(discount.getQuantity()+value);
				break;
			}
		}	
	}
	
	public ProductsDiscountsInfo() {

	}
	
	public ProductsDiscountsInfo(boolean hasProductA, long totalProductsBandC, long totalProductD,
			List<Discount> listDiscounts) {
		super();
		this.hasProductA = hasProductA;
		this.totalProductsBandC = totalProductsBandC;
		this.totalProductD = totalProductD;
		this.listDiscounts = listDiscounts;
	}

	public boolean isHasProductA() {
		return hasProductA;
	}
	public void setHasProductA(boolean hasProductA) {
		this.hasProductA = hasProductA;
	}
	public long getTotalProductsBandC() {
		return totalProductsBandC;
	}
	public void setTotalProductsBandC(long totalProductsBandC) {
		this.totalProductsBandC = totalProductsBandC;
	}
	public long getTotalProductD() {
		return totalProductD;
	}
	public void setTotalProductD(long totalProductD) {
		this.totalProductD = totalProductD;
	}

	public List<Discount> getListDiscounts() {
		return listDiscounts;
	}

	public void setListDiscounts(List<Discount> listDiscounts) {
		this.listDiscounts = listDiscounts;
	}
	

	
}
