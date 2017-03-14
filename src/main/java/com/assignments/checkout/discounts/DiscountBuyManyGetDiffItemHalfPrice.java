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
public class DiscountBuyManyGetDiffItemHalfPrice extends AbstractDiscount implements Discount {

	private Class<? extends Item> itemToDiscountClass;
	private Class<? extends Item> qualifyingItemClass;
	private int quantity;
	

	private DiscountBuyManyGetDiffItemHalfPrice() {
		//Should never be used
		super("");
	}
	
	/**
	 * @param description - Text description of the Discount
	 * @param itemToDiscountClass - Class of item that will be discounted
	 * @param qualifyingItemClass - Class of Items required to qualify for the discount to be valid
	 * @param quantity  - number of qualifying items needed to make the discount valid
	 * 
	 */
	public DiscountBuyManyGetDiffItemHalfPrice(
			String description,
			Class<? extends Item> itemToDiscountClass, 
			Class<? extends Item> qualifyingItemClass, 
			int quantity) {
		super(description);
		this.itemToDiscountClass = itemToDiscountClass;
		this.qualifyingItemClass = qualifyingItemClass;
		this.quantity = quantity;
	}

	/* (non-Javadoc)
	 * @see com.assignments.checkout.discounts.Discount#calculateDiscount()
	 */
	@Override
	public BigDecimal calculateDiscount(List<Item> items) {
		Map<Class<? extends Item>, Long> groupedItems = countRelevantItems(items, this.itemToDiscountClass, this.qualifyingItemClass);

		BigDecimal discount = BigDecimal.ZERO;
		long itemsPurchased;
		
		if (groupedItems.containsKey(this.qualifyingItemClass) && 
				groupedItems.containsKey(this.itemToDiscountClass) && 
				(itemsPurchased = groupedItems.get(this.qualifyingItemClass).longValue()) >= this.quantity) {
			
			BigDecimal price = BigDecimal.ZERO;
			long itemsThatCanBeDiscounted = groupedItems.get(this.itemToDiscountClass).longValue();
			
			for (int count = 0 ; count < itemsPurchased && itemsThatCanBeDiscounted > 0 ; count += this.quantity) {
				if (BigDecimal.ZERO.equals(price)) {
					price = items.stream().unordered()
					.filter(item -> this.itemToDiscountClass.equals(item.getClass()))
					.limit(1).findFirst().get().getPrice();
				}
				discount = discount.add(price.multiply(Discounts.FIFTY_PERCENT.getDiscount()).divide(PERCENT_100));
				itemsThatCanBeDiscounted = itemsThatCanBeDiscounted - (count + 1);
			}
		}
		
		return discount.setScale(2, RoundingMode.UP);
	}

	/* (non-Javadoc)
	 * @see com.assignments.checkout.discounts.Discount#applyDiscounts()
	 */
	@Override
	public boolean discountApplies(List<Item> items) {
		Map<Class<? extends Item>, Long> groupedItems = 
				countRelevantItems(items, this.itemToDiscountClass, this.qualifyingItemClass);

		if (groupedItems.containsKey(this.qualifyingItemClass) && 
				groupedItems.containsKey(this.itemToDiscountClass) && 
				(groupedItems.get(this.qualifyingItemClass).longValue()) >= this.quantity) {
			return true;
		}
		
		return false;
	}
	

}
