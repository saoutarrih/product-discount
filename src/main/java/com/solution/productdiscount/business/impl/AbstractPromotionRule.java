package com.solution.productdiscount.business.impl;

import com.solution.productdiscount.beans.ProductsDiscountsInfo;
import com.solution.productdiscount.business.PromotionRule;

public abstract class AbstractPromotionRule implements PromotionRule {

	protected PromotionRule nextRule;
	 
    public void setNextRule(PromotionRule nextRule) {
	this.nextRule = nextRule;
    }
 
    public boolean applyNextRuleIfExist(ProductsDiscountsInfo productsDiscountsInfo) {
	if (this.nextRule != null) {
	    return this.nextRule.apply(productsDiscountsInfo);
	}
	return false;
    }
}
