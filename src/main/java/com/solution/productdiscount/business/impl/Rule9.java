package com.solution.productdiscount.business.impl;

import com.solution.productdiscount.beans.ProductsDiscountsInfo;

public class Rule9 extends AbstractPromotionRule {

	
	public boolean apply(ProductsDiscountsInfo productsDiscountsInfo) {
		if (applyWhenRule9(productsDiscountsInfo)) {
		    return true;
		}
		return applyNextRuleIfExist(productsDiscountsInfo);
	}
 
	//true	m>1	n>1	m	n

	private boolean applyWhenRule9(ProductsDiscountsInfo productsDiscountsInfo) {
		if(productsDiscountsInfo.isHasProductA() && productsDiscountsInfo.getTotalProductsBandC()>1 &&
				productsDiscountsInfo.getTotalProductD()>1) {
			productsDiscountsInfo.increaseDiscountX(productsDiscountsInfo.getTotalProductsBandC());
			productsDiscountsInfo.increaseDiscountY(productsDiscountsInfo.getTotalProductD());

			return true;
		}
		return false;
	}
	
	
}
