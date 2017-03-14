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
public class Soup extends FoodItem {

	/**
	 * 
	 * @param brand - Company brand of item
	 * @param description - Description of the item
	 * @param price - Charged amount
	 * @param netWeight - Weight without packaging
	 * @param grossWeight - Weight with packaging
	 * @param bestBeforeDate - Best before Date
	 * @param expiryDate - Date to dispose of item
	 * 
	 */
	public Soup(String brand, 
			String description, 
			BigDecimal price, 
			double netWeight, 
			double grossWeight,
			Date bestBeforeDate,
			Date expiryDate) {
		super(brand, description, price, netWeight, grossWeight, bestBeforeDate, expiryDate);
		
	}

}
