package com.assignments.checkout.items.drinkable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.assignments.checkout.AbstractTest;
import com.assignments.checkout.items.ItemFactory;

@SuppressWarnings("javadoc")
public class MilkTest extends AbstractTest {
	
	private Milk milkItem;
	private Milk milkItem2 = new Milk(ItemFactory.MILK_COMP, 
			ItemFactory.MILK_DESC, 
			ItemFactory.MILK_PRICE, 
			ItemFactory.DATE, 
			ItemFactory.MILK_WEIGHT, 
			ItemFactory.MILK_CAPACITY);

	@Before
	public void setUp() throws Exception {
		setActualItems("Milk");
		this.milkItem = (Milk) getActualItems().get(0);
	}

	@Test
	public final void testHashCode() {
		assertEquals(this.milkItem2.hashCode(), this.milkItem.hashCode());
	}

	@Test
	public final void testEqualsObject() {
		assertEquals(this.milkItem2, this.milkItem);
	}

	@Test
	public final void testGetBestBeforeDate() {
		assertEquals(ItemFactory.MILK_CAPACITY, this.milkItem.getMillilitreCapacity());
	}

	@Test
	public final void testGetGrossWeight() {
		assertEquals(ItemFactory.MILK_WEIGHT, this.milkItem.getGrossWeight(), 0);
	}

	@Test
	public final void testGetMillilitreCapacity() {
		assertEquals(ItemFactory.MILK_CAPACITY, this.milkItem.getMillilitreCapacity());
	}

	@Test
	public final void testIsEdible() {
		assertFalse(this.milkItem.isEdible());
	}

	@Test
	public final void testIsDrinkable() {
		assertTrue(this.milkItem.isDrinkable());
	}

}
