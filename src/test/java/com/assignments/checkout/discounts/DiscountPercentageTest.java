package com.assignments.checkout.discounts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Test;

import com.assignments.checkout.AbstractTest;
import com.assignments.checkout.constants.Discounts;
import com.assignments.checkout.items.ItemFactory;
import com.assignments.checkout.items.edible.Bread;
import com.assignments.checkout.items.edible.Soup;

@SuppressWarnings({"javadoc"})
public class DiscountPercentageTest extends AbstractTest {
	
	private DiscountPercentage appliedDiscount;
	private DiscountPercentage noDiscount;

	@Before
	public void setUp() throws Exception {
		setActualItems("Soup", "Soup");
		this.noDiscount = new DiscountPercentage("Bread 50%", Bread.class, Discounts.FIFTY_PERCENT);
		this.appliedDiscount = new DiscountPercentage("Soup 50%", Soup.class, Discounts.FIFTY_PERCENT);
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
