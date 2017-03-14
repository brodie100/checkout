/**
 * 
 */
package com.assignments.checkout.items.drinkable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author BMC
 */
public class Milk extends DrinkItem {

	/**
	 * @param brand - Company brand of item
	 * @param description - Description of the item
	 * @param price - Charged amount
	 * @param grossWeight - Weight with packaging in grams
	 * @param bestBeforeDate - Best before Date
	 * @param millilitreCapacity - Capacity of Item in Millilitres
	 * 
	 */
	public Milk(String brand, 
			String description, 
			BigDecimal price, 
			Date bestBeforeDate, 
			double grossWeight, 
			int millilitreCapacity) {
		super(brand, description, price, bestBeforeDate, grossWeight, millilitreCapacity);
		
	}

}
