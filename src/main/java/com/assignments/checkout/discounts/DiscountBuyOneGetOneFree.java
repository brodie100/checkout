/**
 * 
 */
package com.assignments.checkout.discounts;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import com.assignments.checkout.items.Item;

/**
 * @author BMC
 *
 */
public class DiscountBuyOneGetOneFree extends AbstractDiscount implements Discount {

	//<?> - subclass of an {@code Item} that should be discounted
	private Class<? extends Item> itemToDiscountClass;
	
	
	private DiscountBuyOneGetOneFree() {
		super("");
	}
	
	/**
	 * @param description - Description of discount
	 * @param itemToDiscountClass - Class of item that will be discounted
	 * 
	 */
	public DiscountBuyOneGetOneFree(String description, Class<? extends Item> itemToDiscountClass) {
		super(description);
		this.itemToDiscountClass = itemToDiscountClass;
	}

	/* 
	 * @see com.assignments.checkout.discounts.Discount#calculateDiscount()
	 */
	@Override
	public BigDecimal calculateDiscount(List<Item> items) {
		Map<Class<? extends Item>, Long> groupedItems = countRelevantItems(items, this.itemToDiscountClass);

		BigDecimal discount = BigDecimal.ZERO;
		long numberOfItems;
		if (groupedItems.containsKey(this.itemToDiscountClass) && 
				(numberOfItems = groupedItems.get(this.itemToDiscountClass).longValue()) >= 2) {
			BigDecimal price = BigDecimal.ZERO;
			for (int count = 2 ; count <= numberOfItems ; count += 2) {
				// increase by 2 and add 1 price to discount
				if (BigDecimal.ZERO.equals(price)) {
					price = items.stream().unordered()
					.filter(item -> this.itemToDiscountClass.equals(item.getClass()))
					.limit(1).findFirst().get().getPrice();
				}
				discount = discount.add(price);
			}
		}
		
		return discount.setScale(2, RoundingMode.UP);
	}

	/* 
	 * @see com.assignments.checkout.discounts.Discount#applyDiscounts()
	 */
	@Override
	public boolean discountApplies(List<Item> items) {
		Map<Class<? extends Item>, Long> groupedItems = countRelevantItems(items, this.itemToDiscountClass);

		if (groupedItems.containsKey(this.itemToDiscountClass)) {
			return true;
		}
		
		return false;
	}
}
