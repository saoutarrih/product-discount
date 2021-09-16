package com.solution.productdiscount.business.impl;

import com.solution.productdiscount.beans.ProductsDiscountsInfo;

public class Rule4 extends AbstractPromotionRule {

	
	public boolean apply(ProductsDiscountsInfo productsDiscountsInfo) {
		if (applyWhenRule4(productsDiscountsInfo)) {
		    return true;
		}
		return applyNextRuleIfExist(productsDiscountsInfo);
	}
 
	//true	1	0	1	0

	private boolean applyWhenRule4(ProductsDiscountsInfo productsDiscountsInfo) {
		if(productsDiscountsInfo.isHasProductA() && productsDiscountsInfo.getTotalProductsBandC()==1 &&
				productsDiscountsInfo.getTotalProductD()==0) {
			productsDiscountsInfo.increaseDiscountX(1);
			return true;
		}
		return false;
	}
	
	
}
