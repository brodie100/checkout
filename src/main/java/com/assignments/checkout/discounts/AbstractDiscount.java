/**
 * 
 */
package com.assignments.checkout.discounts;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.assignments.checkout.items.Item;

/**
 * @author BMC
 *
 */
public abstract class AbstractDiscount {
	
	private String description = "%s %s off: -%sp";
	
	protected static final BigDecimal PERCENT_100 = BigDecimal.valueOf(100);
	
	/**
	 * @param description - Description of discount
	 * 
	 */
	public AbstractDiscount(String description) {
		this.description = description;
	}
	
	@SafeVarargs
	protected static Map<Class<? extends Item>, Long>  
	countRelevantItems(List<Item> items, Class<? extends Item>... itemsToDiscountClass) {
		List<Class<? extends Item>> classes = Arrays.asList(itemsToDiscountClass);
		return items.stream()
				.filter(item -> classes.contains(item.getClass()))
				.collect(Collectors.groupingByConcurrent(Item::getClass, Collectors.counting()));
	}

	/**
	 * @return String - the description
	 */
	public String getDescription() {
		return this.description;
	}

}
