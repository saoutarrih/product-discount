package com.solution.productdiscount.business.impl;

import com.solution.productdiscount.beans.ProductsDiscountsInfo;

public class Rule1 extends AbstractPromotionRule {

	
	public boolean apply(ProductsDiscountsInfo productsDiscountsInfo) {
		if (applyWhenRule1(productsDiscountsInfo)) {
		    return true;
		}
		return applyNextRuleIfExist(productsDiscountsInfo);
	}
 
	private boolean applyWhenRule1(ProductsDiscountsInfo productsDiscountsInfo) {
		if(!productsDiscountsInfo.isHasProductA() && productsDiscountsInfo.getTotalProductsBandC()>1 &&
				(productsDiscountsInfo.getTotalProductD()==0 ||productsDiscountsInfo.getTotalProductD()>=1) ) {
			productsDiscountsInfo.increaseDiscountX(productsDiscountsInfo.getTotalProductsBandC());
			return true;
		}
		return false;
	}
	
	
}
