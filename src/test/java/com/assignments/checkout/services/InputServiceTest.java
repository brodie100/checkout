package com.assignments.checkout.services;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.assignments.checkout.constants.Function;
import com.assignments.checkout.exceptions.InvalidFunctionException;
import com.assignments.checkout.items.Item;


@SuppressWarnings({"static-method", "javadoc"})
public class InputServiceTest {

	
	@Test
	public final void testGetValidFunctionCall() throws InvalidFunctionException {
		Function function = 
				InputService.getValidFunctionCall("Soup", "Milk", "Bread", "Apples", "NonExistant", "PriceBasket");
		assertEquals(Function.PRICE_BASKET, function);
	}
	
	@Test(expected=InvalidFunctionException.class)
	public final void testGetInvalidFunctionCall() throws InvalidFunctionException {
		InputService.getValidFunctionCall("Soup", "Milk", "Bread", "Apples", "NonExistant", "PriceWhat");
	}

	@Test
	public final void testGetItemsFromArguments() {
		List<Item> items = 
				InputService.getItemsFromArguments("Soup", "Milk", "Bread", "Apples", "NonExistant", "PriceBasket");
		assertEquals(4, items.size());
	}

}
