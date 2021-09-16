package com.solution.productdiscount.business.impl;

import com.solution.productdiscount.beans.ProductsDiscountsInfo;

public class Rule5 extends AbstractPromotionRule {

	
	public boolean apply(ProductsDiscountsInfo productsDiscountsInfo) {
		if (applyWhenRule5(productsDiscountsInfo)) {
		    return true;
		}
		return applyNextRuleIfExist(productsDiscountsInfo);
	}
 
	//true	1	1	1	1

	private boolean applyWhenRule5(ProductsDiscountsInfo productsDiscountsInfo) {
		if(productsDiscountsInfo.isHasProductA() && productsDiscountsInfo.getTotalProductsBandC()==1 &&
				productsDiscountsInfo.getTotalProductD()==1) {
			productsDiscountsInfo.increaseDiscountX(1);
			productsDiscountsInfo.increaseDiscountY(1);

			return true;
		}
		return false;
	}
	
	
}
