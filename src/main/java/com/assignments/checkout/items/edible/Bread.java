/**
 * 
 */
package com.assignments.checkout.items.edible;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author BMC
 *
 */
public class Bread extends FoodItem {

	/**
	 * 
	 * @param brand - Company brand of item
	 * @param description - Description of the item
	 * @param price - Charged amount
	 * @param netWeight - Weight without packaging in grams
	 * @param grossWeight - Weight with packaging in grams
	 * @param expiryDate - Date to Dispose of item
	 * @param bestBeforeDate - Best before Date
	 * 
	 */
	public Bread(String brand, 
			String description, 
			BigDecimal price, 
			double netWeight, 
			double grossWeight,
			Date bestBeforeDate,
			Date expiryDate) {
		super(brand, description, price, netWeight, grossWeight, bestBeforeDate, expiryDate);
		
	}

}
