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
public class Apples extends FoodItem {

    private final int quantity;
    /**
     * 
     * @param brand - Company brand of item
     * @param description - Description of the item
     * @param price - Charged amount
     * @param netWeight - Weight without packaging in grams
     * @param grossWeight - Weight with packaging in grams
     * @param expiryDate - Date to Dispose of item
     * @param bestBeforeDate - Best before Date
     * @param quantity - Number of items in pack
     * 
     */
    public Apples(String brand, 
            String description, 
            BigDecimal price, 
            double netWeight, 
            double grossWeight,
            Date bestBeforeDate,
            Date expiryDate, 
            int quantity) {
        super(brand, description, price, netWeight, grossWeight, bestBeforeDate, expiryDate);
        this.quantity = quantity;
        
    }
    
    /**
     * @return int - Quantity of apples in pack 
     */
    public int getQuantity() {
        return this.quantity;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + this.quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apples other = (Apples) obj;
		if (this.quantity != other.quantity)
			return false;
		return true;
	}

}
