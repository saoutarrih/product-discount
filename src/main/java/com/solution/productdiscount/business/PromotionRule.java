
package com.solution.productdiscount.business;

import com.solution.productdiscount.beans.ProductsDiscountsInfo;

public interface PromotionRule {
	
	public void setNextRule(PromotionRule nextRule);
    public abstract boolean apply(ProductsDiscountsInfo productsDiscountsInfo);

}
