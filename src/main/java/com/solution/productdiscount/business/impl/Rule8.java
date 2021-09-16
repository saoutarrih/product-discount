package com.solution.productdiscount.business.impl;

import com.solution.productdiscount.beans.ProductsDiscountsInfo;

public class Rule8 extends AbstractPromotionRule {

	
	public boolean apply(ProductsDiscountsInfo productsDiscountsInfo) {
		if (applyWhenRule8(productsDiscountsInfo)) {
		    return true;
		}
		return applyNextRuleIfExist(productsDiscountsInfo);
	}
 
	//true	m>1	1	m	1

	private boolean applyWhenRule8(ProductsDiscountsInfo productsDiscountsInfo) {
		if(productsDiscountsInfo.isHasProductA() && productsDiscountsInfo.getTotalProductsBandC()>1 &&
				productsDiscountsInfo.getTotalProductD()==1) {
			productsDiscountsInfo.increaseDiscountX(productsDiscountsInfo.getTotalProductsBandC());
			productsDiscountsInfo.increaseDiscountY(1);


			return true;
		}
		return false;
	}
	
	
}
