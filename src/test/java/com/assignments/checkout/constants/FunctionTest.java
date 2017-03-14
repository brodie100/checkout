package com.assignments.checkout.constants;

import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings({"javadoc", "static-method"})
public class FunctionTest {


	@Test
	public final void testToString() {
		assertEquals("PriceBasket", Function.PRICE_BASKET.toString());
	}

	@Test
	public final void testIsValidFunction() {
		assertEquals(Boolean.TRUE, Boolean.valueOf(Function.isValidFunction(Function.PRICE_BASKET.toString())));
	}
	
	@Test
	public final void testIsNotValidFunction() {
		assertEquals(Boolean.FALSE, Boolean.valueOf(Function.isValidFunction("Non-existant")));
	}

	@Test
	public final void testReturnFunction() {
		assertEquals(Function.PRICE_BASKET, Function.returnFunction("PriceBasket"));
	}

}
