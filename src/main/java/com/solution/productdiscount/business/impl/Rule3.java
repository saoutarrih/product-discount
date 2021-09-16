package com.solution.productdiscount.business.impl;

import com.solution.productdiscount.beans.ProductsDiscountsInfo;

public class Rule3 extends AbstractPromotionRule {

	
	public boolean apply(ProductsDiscountsInfo productsDiscountsInfo) {
		if (applyWhenRule3(productsDiscountsInfo)) {
		    return true;
		}
		return applyNextRuleIfExist(productsDiscountsInfo);
	}
 
	// true	0	n>1	0	n
	private boolean applyWhenRule3(ProductsDiscountsInfo productsDiscountsInfo) {
		if(productsDiscountsInfo.isHasProductA() && productsDiscountsInfo.getTotalProductsBandC()==0 &&
				productsDiscountsInfo.getTotalProductD()>1) {
			productsDiscountsInfo.increaseDiscountY(productsDiscountsInfo.getTotalProductD());
			return true;
		}
		return false;
	}
	
	
}
