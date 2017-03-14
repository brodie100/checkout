package com.assignments.checkout.discounts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.assignments.checkout.AbstractTest;
import com.assignments.checkout.items.Item;
import com.assignments.checkout.items.ItemFactory;
import com.assignments.checkout.items.edible.Bread;
import com.assignments.checkout.items.edible.Soup;

@SuppressWarnings({"javadoc"})
public class DiscountBuyManyGetDiffItemHalfPriceTest extends AbstractTest {

	private DiscountBuyManyGetDiffItemHalfPrice appliedDiscount;
	private DiscountBuyManyGetDiffItemHalfPrice noDiscount;
	private List<Item> multipleQualifiedItems;
	
	private static final BigDecimal BIG_TWO = BigDecimal.valueOf(2);
	private static final String SOUP_DESC = "Soup 50% off";
	
	@Before
	public void setUp() throws Exception {
		setActualItems("Soup", "Bread", "Bread");
		this.multipleQualifiedItems = buildItemList("Soup", "Soup", "Bread", "Bread", "Bread", "Bread");
		this.noDiscount = new DiscountBuyManyGetDiffItemHalfPrice("Bread 50% off", Bread.class, Soup.class, 2);
		this.appliedDiscount = new DiscountBuyManyGetDiffItemHalfPrice("Soup 50% off", Soup.class, Bread.class, 2);
	}

	@Test
	public final void testCalculateDiscountWithOneQualifyingItem() {
		assertEquals(ItemFactory.SOUP_PRICE.divide(BIG_TWO).setScale(2, RoundingMode.UP), this.appliedDiscount.calculateDiscount(this.actualItems));
	}
	
	@Test
	public final void testCalculateDiscountWithQualifyingItems() {
		assertEquals(ItemFactory.SOUP_PRICE, this.appliedDiscount.calculateDiscount(this.multipleQualifiedItems));
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

	@Test
	public final void testCountRelevantItems() {
		assertEquals(1, AbstractDiscount.countRelevantItems(this.actualItems, Soup.class).size());
	}

	@Test
	public final void testGetDescription() {
		assertEquals(SOUP_DESC, this.appliedDiscount.getDescription());
	}

}
