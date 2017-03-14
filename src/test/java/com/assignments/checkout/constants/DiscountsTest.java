package com.assignments.checkout.constants;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

@SuppressWarnings({"javadoc", "static-method"})
public class DiscountsTest {

	@Test
	public final void testToString() {
		assertEquals("80%", Discounts.EIGHTY_PERCENT.toString());
	}

	@Test
	public final void testGetDiscount() {
		assertEquals(BigDecimal.valueOf(80), Discounts.EIGHTY_PERCENT.getDiscount());
	}

}
