/**
 * 
 */
package com.assignments.checkout.discounts;

import java.math.BigDecimal;
import java.util.List;

import com.assignments.checkout.items.Item;

/**
 * @author BMC
 *
 */
public interface Discount {
    
    /**
     * @param items - Shopping Basket Items
     * @return BigDecimal - Return a double representing the total amount to take of the 
     * total bill
     */
	public BigDecimal calculateDiscount(List<Item> items);
    /**
     * @param items - Shopping Basket Items
     * @return boolean - If the discount is relevant.
     */
    boolean discountApplies(List<Item> items);
    
    /**
     * @return String Description of discount
     */
    String getDescription();

}
