package com.solution.productdiscount.business.impl;

import com.solution.productdiscount.beans.ProductsDiscountsInfo;

public class Rule6 extends AbstractPromotionRule {

	
	public boolean apply(ProductsDiscountsInfo productsDiscountsInfo) {
		if (applyWhenRule6(productsDiscountsInfo)) {
		    return true;
		}
		return applyNextRuleIfExist(productsDiscountsInfo);
	}
 
	//true	1	n>1	1	n

	private boolean applyWhenRule6(ProductsDiscountsInfo productsDiscountsInfo) {
		if(productsDiscountsInfo.isHasProductA() && productsDiscountsInfo.getTotalProductsBandC()==1 &&
				productsDiscountsInfo.getTotalProductD()>1) {
			productsDiscountsInfo.increaseDiscountX(1);
			productsDiscountsInfo.increaseDiscountY(productsDiscountsInfo.getTotalProductD());

			return true;
		}
		return false;
	}
	
	
}
