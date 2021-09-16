package com.solution.productdiscount.business.impl;

import com.solution.productdiscount.beans.ProductsDiscountsInfo;

public class Rule7 extends AbstractPromotionRule {

	
	public boolean apply(ProductsDiscountsInfo productsDiscountsInfo) {
		if (applyWhenRule7(productsDiscountsInfo)) {
		    return true;
		}
		return applyNextRuleIfExist(productsDiscountsInfo);
	}
 
	//true	m>1	0	m	0

	private boolean applyWhenRule7(ProductsDiscountsInfo productsDiscountsInfo) {
		if(productsDiscountsInfo.isHasProductA() && productsDiscountsInfo.getTotalProductsBandC()>1 &&
				productsDiscountsInfo.getTotalProductD()==0) {
			productsDiscountsInfo.increaseDiscountX(productsDiscountsInfo.getTotalProductsBandC());

			return true;
		}
		return false;
	}
	
	
}
