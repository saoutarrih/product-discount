package com.solution.productdiscount;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.solution.productdiscount.beans.Discount;
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

@SpringBootTest
class ProductDiscountApplicationTest {

	@Test
	void contextLoads() {
	}
	@Test
	public void testCreateChainTest1Rule1() {
		
		// Rule1
		// false	m>1	0	m	0
		
		List<Discount> listDiscount = new ArrayList<>();
		listDiscount.add(new Discount("X", 0));
		listDiscount.add(new Discount("Y", 0));
		PromotionRule firstRule = createRulesChain();
		ProductsDiscountsInfo productsDiscountsInfo = new ProductsDiscountsInfo(false, 5, 0, listDiscount);		
		firstRule.apply(productsDiscountsInfo);		
		productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("X")).count();
		
		Assert.assertEquals(5L, productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("X")).collect(Collectors.reducing((a, b) -> null)).get().getQuantity());
		Assert.assertEquals(0, productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("Y")).collect(Collectors.reducing((a, b) -> null)).get().getQuantity());

	}

	@Test
	public void testCreateChainTest2Rule1() {
		 //Rule1
		//false	m>1	n>1	m	0
		List<Discount> listDiscount = new ArrayList<>();
		listDiscount.add(new Discount("X", 0));
		listDiscount.add(new Discount("Y", 0));
		PromotionRule firstRule = createRulesChain();
		ProductsDiscountsInfo productsDiscountsInfo = new ProductsDiscountsInfo(false, 20, 30, listDiscount);		
		firstRule.apply(productsDiscountsInfo);		
		productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("X")).count();
		
		Assert.assertEquals(20L, productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("X")).collect(Collectors.reducing((a, b) -> null)).get().getQuantity());
		Assert.assertEquals(0, productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("Y")).collect(Collectors.reducing((a, b) -> null)).get().getQuantity());

	}
	
	@Test
	public void testCreateChainTest3Rule1() {
		 //Rule1
		//false	m>1	1	m	0
		List<Discount> listDiscount = new ArrayList<>();
		listDiscount.add(new Discount("X", 0));
		listDiscount.add(new Discount("Y", 0));
		PromotionRule firstRule = createRulesChain();
		ProductsDiscountsInfo productsDiscountsInfo = new ProductsDiscountsInfo(false, 20, 1, listDiscount);		
		firstRule.apply(productsDiscountsInfo);		
		productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("X")).count();
		
		Assert.assertEquals(20L, productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("X")).collect(Collectors.reducing((a, b) -> null)).get().getQuantity());
		Assert.assertEquals(0, productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("Y")).collect(Collectors.reducing((a, b) -> null)).get().getQuantity());


	}
	
	@Test
	public void testCreateChainTestRule2() {
		// Rule2
		// true	0	1	0	1

		List<Discount> listDiscount = new ArrayList<>();
		listDiscount.add(new Discount("X", 0));
		listDiscount.add(new Discount("Y", 0));
		PromotionRule firstRule = createRulesChain();
		ProductsDiscountsInfo productsDiscountsInfo = new ProductsDiscountsInfo(true, 0, 1, listDiscount);		
		firstRule.apply(productsDiscountsInfo);		
		productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("X")).count();
		
		Assert.assertEquals(0L, productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("X")).collect(Collectors.reducing((a, b) -> null)).get().getQuantity());
		Assert.assertEquals(1L, productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("Y")).collect(Collectors.reducing((a, b) -> null)).get().getQuantity());


	}
	
	@Test
	public void testCreateChainTestRule3() {
		// Rule3
		//true	0	n>1	0	n

		List<Discount> listDiscount = new ArrayList<>();
		listDiscount.add(new Discount("X", 0));
		listDiscount.add(new Discount("Y", 0));
		PromotionRule firstRule = createRulesChain();
		ProductsDiscountsInfo productsDiscountsInfo = new ProductsDiscountsInfo(true, 0, 10, listDiscount);		
		firstRule.apply(productsDiscountsInfo);		
		productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("X")).count();
		
		Assert.assertEquals(0L, productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("X")).collect(Collectors.reducing((a, b) -> null)).get().getQuantity());
		Assert.assertEquals(10L, productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("Y")).collect(Collectors.reducing((a, b) -> null)).get().getQuantity());


	}

	@Test
	public void testCreateChainTestRule4() {
		// Rule4
		// true	1	0	1	0

		List<Discount> listDiscount = new ArrayList<>();
		listDiscount.add(new Discount("X", 0));
		listDiscount.add(new Discount("Y", 0));
		PromotionRule firstRule = createRulesChain();
		ProductsDiscountsInfo productsDiscountsInfo = new ProductsDiscountsInfo(true, 1, 0, listDiscount);		
		firstRule.apply(productsDiscountsInfo);		
		productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("X")).count();
		
		Assert.assertEquals(1L, productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("X")).collect(Collectors.reducing((a, b) -> null)).get().getQuantity());
		Assert.assertEquals(0L, productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("Y")).collect(Collectors.reducing((a, b) -> null)).get().getQuantity());


	}
	
	@Test
	public void testCreateChainTestRule5() {
		//Rule5
		//true	1	1	1	1

		List<Discount> listDiscount = new ArrayList<>();
		listDiscount.add(new Discount("X", 0));
		listDiscount.add(new Discount("Y", 0));
		PromotionRule firstRule = createRulesChain();
		ProductsDiscountsInfo productsDiscountsInfo = new ProductsDiscountsInfo(true, 1, 1, listDiscount);		
		firstRule.apply(productsDiscountsInfo);		
		productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("X")).count();
		
		Assert.assertEquals(1L, productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("X")).collect(Collectors.reducing((a, b) -> null)).get().getQuantity());
		Assert.assertEquals(1L, productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("Y")).collect(Collectors.reducing((a, b) -> null)).get().getQuantity());


	}
	
	@Test
	public void testCreateChainTestRule6() {
		//Rule6
		//true	1	n>1	1	n

		List<Discount> listDiscount = new ArrayList<>();
		listDiscount.add(new Discount("X", 0));
		listDiscount.add(new Discount("Y", 0));
		PromotionRule firstRule = createRulesChain();
		ProductsDiscountsInfo productsDiscountsInfo = new ProductsDiscountsInfo(true, 1, 10, listDiscount);		
		firstRule.apply(productsDiscountsInfo);		
		productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("X")).count();
		
		Assert.assertEquals(1L, productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("X")).collect(Collectors.reducing((a, b) -> null)).get().getQuantity());
		Assert.assertEquals(10L, productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("Y")).collect(Collectors.reducing((a, b) -> null)).get().getQuantity());


	}
	
	@Test
	public void testCreateChainTestRule7() {
		//Rule7
		//true	m>1	0	m	0

		List<Discount> listDiscount = new ArrayList<>();
		listDiscount.add(new Discount("X", 0));
		listDiscount.add(new Discount("Y", 0));
		PromotionRule firstRule = createRulesChain();
		ProductsDiscountsInfo productsDiscountsInfo = new ProductsDiscountsInfo(true, 15, 0, listDiscount);		
		firstRule.apply(productsDiscountsInfo);		
		productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("X")).count();
		
		Assert.assertEquals(15L, productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("X")).collect(Collectors.reducing((a, b) -> null)).get().getQuantity());
		Assert.assertEquals(0, productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("Y")).collect(Collectors.reducing((a, b) -> null)).get().getQuantity());


	}
	
	@Test
	public void testCreateChainTestRule8() {
		//Rule8
		//true	m>1	1	m	1
		List<Discount> listDiscount = new ArrayList<>();
		listDiscount.add(new Discount("X", 0));
		listDiscount.add(new Discount("Y", 0));
		PromotionRule firstRule = createRulesChain();
		ProductsDiscountsInfo productsDiscountsInfo = new ProductsDiscountsInfo(true, 15, 1, listDiscount);		
		firstRule.apply(productsDiscountsInfo);		
		productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("X")).count();
		
		Assert.assertEquals(15L, productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("X")).collect(Collectors.reducing((a, b) -> null)).get().getQuantity());
		Assert.assertEquals(1L, productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("Y")).collect(Collectors.reducing((a, b) -> null)).get().getQuantity());


	}
	
	@Test
	public void testCreateChainTestRule9() {
		//Rule9
		//true	m>1	n>1	m	n

		List<Discount> listDiscount = new ArrayList<>();
		listDiscount.add(new Discount("X", 0));
		listDiscount.add(new Discount("Y", 0));
		PromotionRule firstRule = createRulesChain();
		ProductsDiscountsInfo productsDiscountsInfo = new ProductsDiscountsInfo(true, 15, 19, listDiscount);		
		firstRule.apply(productsDiscountsInfo);		
		productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("X")).count();
		
		Assert.assertEquals(15L, productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("X")).collect(Collectors.reducing((a, b) -> null)).get().getQuantity());
		Assert.assertEquals(19L, productsDiscountsInfo.getListDiscounts().stream().filter(discount -> discount.getId().equals("Y")).collect(Collectors.reducing((a, b) -> null)).get().getQuantity());


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
