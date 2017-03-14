package com.assignments.checkout.discounts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Test;

import com.assignments.checkout.AbstractTest;
import com.assignments.checkout.items.ItemFactory;
import com.assignments.checkout.items.edible.Bread;
import com.assignments.checkout.items.edible.Soup;

@SuppressWarnings({"javadoc"})
public class DiscountBuyOneGetOneFreeTest extends AbstractTest {

	private DiscountBuyOneGetOneFree appliedDiscount;
	private DiscountBuyOneGetOneFree noDiscount;
	
	@Before
	public void setUp() throws Exception {
		setActualItems("Soup", "Soup");
		this.noDiscount = new DiscountBuyOneGetOneFree("Bread 50% off", Bread.class);
		this.appliedDiscount = new DiscountBuyOneGetOneFree("Soup BOGOF", Soup.class);
	}

	@Test
	public final void testCalculateDiscountWithQualifyingItems() {
		assertEquals(ItemFactory.SOUP_PRICE, this.appliedDiscount.calculateDiscount(this.actualItems));
	}
	
	@Test
	public final void testCalculateDiscountWithNoQualifyingItems() {
		assertEquals(BigDecimal.ZERO.setScale(2, RoundingMode.UP), this.noDiscount.calculateDiscount(this.actualItems));
	}


	@Test
	public final void testDiscountAppliesPositive() {
		assertTrue(this.appliedDiscount.discountApplies(this.actualItems));
	}
	@Test
	public final void testDiscountAppliesNegative() {
		assertFalse(this.noDiscount.discountApplies(this.actualItems));
	}

}
