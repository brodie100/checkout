/**
 * 
 */
package com.assignments.checkout.items;

import java.util.Arrays;

import junit.framework.TestCase;

/**
 * @author BMC
 *
 */
public class ItemFactoryTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test method for {@link com.assignments.checkout.items.ItemFactory#createItems(java.util.List)}.
	 */
	public static void testCreateItemsWithNonItemsIncluded() {
		assertEquals(4, 
				ItemFactory.createItems(Arrays.asList("Soup", "Milk", "Bread", "Apples", "NonExistant", "PriceBasket"))
				.size());
	}
	
	

}
