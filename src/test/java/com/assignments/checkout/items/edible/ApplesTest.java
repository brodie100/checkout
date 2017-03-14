package com.assignments.checkout.items.edible;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.assignments.checkout.AbstractTest;
import com.assignments.checkout.items.ItemFactory;

@SuppressWarnings("javadoc")
public class ApplesTest extends AbstractTest {

	private Apples appleItem;
	private Apples appleItem2 = new Apples(ItemFactory.APPLES_COMP, 
			ItemFactory.APPLES_DESC, 
			ItemFactory.APPLES_PRICE,
			ItemFactory.APPLES_WEIGHT,
			ItemFactory.APPLES_WEIGHT,
			ItemFactory.DATE,
			ItemFactory.DATE,
			5);
	
	@Before
	public void setUp() throws Exception {
		setActualItems("Apples");
		this.appleItem = (Apples) this.actualItems.get(0);
	}

	@Test
	public final void testGetQuantity() {
		assertEquals(5, this.appleItem.getQuantity());
	}

	@Test
	public final void testGetGrossWeight() {
		assertEquals(ItemFactory.APPLES_WEIGHT, this.appleItem.getGrossWeight(), 0);
	}

	@Test
	public final void testGetNetWeight() {
		assertEquals(ItemFactory.APPLES_WEIGHT, this.appleItem.getNetWeight(), 0);
	}

	@Test
	public final void testGetExpiryDate() {
		assertEquals(ItemFactory.DATE, this.appleItem.getExpiryDate());
	}

	@Test
	public final void testGetBestBeforeDate() {
		assertEquals(ItemFactory.DATE, this.appleItem.getBestBeforeDate());
	}
	
	@Test
	public final void testHashCode() {
		assertEquals(this.appleItem2.hashCode(), this.appleItem.hashCode());
	}

	@Test
	public final void testEqualsObject() {
		assertEquals(this.appleItem2, this.appleItem);
	}
	
	@Test
	public final void testEqualsSameObject() {
		assertEquals(this.appleItem2, this.appleItem2);
	}

}
