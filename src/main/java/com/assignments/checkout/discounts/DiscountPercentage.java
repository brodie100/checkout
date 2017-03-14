/**
 * 
 */
package com.assignments.checkout.discounts;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import com.assignments.checkout.constants.Discounts;
import com.assignments.checkout.items.Item;

/**
 * @author BMC
 *
 */
public class DiscountPercentage extends AbstractDiscount implements Discount {

	private Discounts discountAmount;
	private Class<? extends Item> itemToDiscountClass;
	
	private DiscountPercentage() {
		super("");
	}
	
	/**
	 * @param description - Description of discount
	 * @param itemToDiscountClass - Class of item that will be discounted
	 * @param discountAmount - amount to discount this item by
	 * 
	 */
	public DiscountPercentage(String description, Class<? extends Item> itemToDiscountClass, Discounts discountAmount) {
		super(description);
		this.itemToDiscountClass = itemToDiscountClass;
		this.discountAmount = discountAmount;
	}

	/* 
	 * @see com.assignments.checkout.discounts.Discount#calculateDiscount()
	 */
	@Override
	public BigDecimal calculateDiscount(List<Item> items) {
		Map<Class<? extends Item>, Long> groupedItems = countRelevantItems(items, this.itemToDiscountClass);

		BigDecimal discount = BigDecimal.ZERO;
		if (groupedItems.containsKey(this.itemToDiscountClass)) {
			BigDecimal price = BigDecimal.ZERO;
			
			for (int count = 0 ; count < groupedItems.get(this.itemToDiscountClass).longValue() ; count++) {
				// increase by 2 and add 1 price to discount
				if (BigDecimal.ZERO.equals(price)) {
					price = items.stream().unordered()
							.filter(item -> this.itemToDiscountClass.equals(item.getClass()))
							.limit(1).findFirst().get().getPrice();
				}
				BigDecimal discountedAount = BigDecimal.ZERO;
				if (!BigDecimal.ZERO.equals(price))
					discountedAount = price.multiply(this.discountAmount.getDiscount()).divide(PERCENT_100);
				discount = discount.add(discountedAount);
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
		return groupedItems.containsKey(this.itemToDiscountClass);
	}
	

}
