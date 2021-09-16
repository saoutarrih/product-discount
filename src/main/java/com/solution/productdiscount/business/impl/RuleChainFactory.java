package com.solution.productdiscount.business.impl;

import java.util.Arrays;
import java.util.List;

import com.solution.productdiscount.business.PromotionRule;


public class RuleChainFactory {
	private RuleChainFactory() {
	}

	private static class Holder {
		private static RuleChainFactory instance = new RuleChainFactory();
	}

	public static RuleChainFactory getInstance() {
		return Holder.instance;
	}

	public PromotionRule createPromotionsChain(PromotionRule... rules) {

		
		List<PromotionRule> promotionList = Arrays.asList(rules);
		PromotionRule previousRule = promotionList.get(0);
		for (int i = 1; i < promotionList.size(); i++) {
			PromotionRule currentRule = promotionList.get(i);
			previousRule.setNextRule(currentRule);
			previousRule = currentRule;
		}

		return promotionList.get(0);
	}
}
