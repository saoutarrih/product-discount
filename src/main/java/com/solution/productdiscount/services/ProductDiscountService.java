package com.solution.productdiscount.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.solution.productdiscount.beans.Discount;
import com.solution.productdiscount.beans.Payload;
import com.solution.productdiscount.beans.ProductsDiscountsInfo;
import com.solution.productdiscount.business.PromotionRule;
import com.solution.productdiscount.business.impl.Rule1;
import com.solution.productdiscount.business.impl.Rule2;
import com.solution.productdiscount.business.impl.Rule3;
import com.solution.productdiscount.business.impl.Rule4;
import com.solution.productdiscount.business.impl.Rule5;
import com.solution.productdiscount.business.impl.Rule6;
import com.solution.productdiscount.business.impl.Rule7;
import com.solution.productdiscount.business.impl.Rule8;
import com.solution.productdiscount.business.impl.Rule9;
import com.solution.productdiscount.business.impl.RuleChainFactory;

@Service
public class ProductDiscountService {
	
	public List<Discount> calculatePromotions(Payload payload) {
		
		List<Discount> listDiscount = new ArrayList<>();
		listDiscount.add(new Discount("X", 0));
		listDiscount.add(new Discount("Y", 0));
		
		if(payload!=null) {
			if(!payload.getProducts().isEmpty()) {
				
				long countA=payload.getProducts().stream().filter(product -> product.getId().equals("A")).count();
				long countB=payload.getProducts().stream().filter(product -> product.getId().equals("B")).count();
				long countC=payload.getProducts().stream().filter(product -> product.getId().equals("C")).count();
				long countD=payload.getProducts().stream().filter(product -> product.getId().equals("D")).count();
				
				ProductsDiscountsInfo productsDiscountsInfo = new ProductsDiscountsInfo(countA == 0 ? false : true, countB + countC , countD, listDiscount);
				
				PromotionRule firstRule = createRulesChain();
				
				firstRule.apply(productsDiscountsInfo);
				
				return productsDiscountsInfo.getListDiscounts();
			}
			else {
				return listDiscount;
			}	
		}
		else {
			return listDiscount;
		}

	}
	
	private PromotionRule createRulesChain() {

		PromotionRule startRule = RuleChainFactory.getInstance().createPromotionsChain(
		   new Rule1(),
		   new Rule2(),
		   new Rule3(),
		   new Rule4(),
           new Rule5(),
           new Rule6(),
           new Rule7(),
           new Rule8(),
           new Rule9());

		return startRule;
	}
		
}
