package com.assignments.checkout;

import java.util.Arrays;
import java.util.List;

import com.assignments.checkout.items.Item;
import com.assignments.checkout.items.ItemFactory;

/**
 * @author BMC
 *
 */
public abstract class AbstractTest {
	
	protected List<Item> actualItems;

	protected static List<Item> buildItemList(String... itemStrings) {
		return ItemFactory.createItems(Arrays.asList(itemStrings));
	}
	
	
	protected List<Item> getActualItems() {
		return this.actualItems;
	}
	
	protected void setActualItems(String... itemStrings) {
		this.actualItems = ItemFactory.createItems(Arrays.asList(itemStrings));
	}
}
