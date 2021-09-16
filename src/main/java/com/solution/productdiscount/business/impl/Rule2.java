package com.solution.productdiscount.business.impl;

import com.solution.productdiscount.beans.ProductsDiscountsInfo;

public class Rule2 extends AbstractPromotionRule {

	
	public boolean apply(ProductsDiscountsInfo productsDiscountsInfo) {
		if (applyWhenRule2(productsDiscountsInfo)) {
		    return true;
		}
		return applyNextRuleIfExist(productsDiscountsInfo);
	}
 
	// true	0	1	0	1
	private boolean applyWhenRule2(ProductsDiscountsInfo productsDiscountsInfo) {
		if(productsDiscountsInfo.isHasProductA() && productsDiscountsInfo.getTotalProductsBandC()==0 &&
				productsDiscountsInfo.getTotalProductD()==1) {
			productsDiscountsInfo.increaseDiscountY(1);
			return true;
		}
		return false;
	}
	
	
}
