/**
 * 
 */
package com.assignments.checkout.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.assignments.checkout.discounts.Discount;
import com.assignments.checkout.items.Item;

/**
 * @author BMC
 * If there are to be different versions of this Checkout Service I would place 
 * it behind an interface
 */
public final class CheckoutService {

	private List<Discount> discounts;
	private static final BigDecimal ZERO_PENCE = BigDecimal.ZERO.setScale(2);
	
	private static final String OFFER_DESCRIPTION = "%s: -£%s"; //fix to work out pence and pounds to meet reqs
	private static final String SUBTOTAL_DESCRIPTION = "Subtotal: £%s";
	private static final String TOTAL_DESCRIPTION = "Total price: £%s" ;
	

	@SuppressWarnings("unused")
	private CheckoutService() {
		// Stop instantiation
	}
	
	/**
	 * @param discounts - List of discounted items
	 */
	public CheckoutService(Optional<List<Discount>> discounts) {
		this.discounts = discounts.orElse(Collections.emptyList());
	}
	
	/**
	 * @param items - List of items supplied for totalling 
	 * @return BigDecimal - the amount of the total basket before com.assignments.checkout.discounts
	 */
	private static BigDecimal subtotalBasket(List<Item> items) {
		return items.stream()
				.map(Item::getPrice)
				.reduce(ZERO_PENCE, BigDecimal::add)
				.setScale(2, RoundingMode.DOWN);
    }
    

    
    /**
     * @param total - total of basket
     * @param discountAmount - com.assignments.checkout.discounts total
     * @return BigDecimal - Total after com.assignments.checkout.discounts have been subtracted
     */
    private static BigDecimal calculateTotalPrice(BigDecimal total, BigDecimal discountAmount) {
    	return total.subtract(discountAmount).setScale(2, RoundingMode.DOWN);
    }
    
    
    /**
     * FIXME: HACK, This is serving a dual purpose which isn't clean, need to separate
     *        discount totals with descriptions  
     * @param items - bought item list
     * @return 
     */
    private Map<String, BigDecimal> buildDiscountAndOutput(List<Item> items) {
    	if (this.discounts.isEmpty()) {
    		return Collections.singletonMap("(No offers available)", BigDecimal.ZERO);
    	}
    	Map<String, BigDecimal> discountsMap = new HashMap<>();
    	this.discounts.stream().forEach(discount -> {
    		BigDecimal discountAmount = discount.calculateDiscount(items).setScale(2, RoundingMode.DOWN);
    		discountsMap.put(String.format(OFFER_DESCRIPTION, discount.getDescription(), discountAmount), 
    				discountAmount);
    	});
    	
    	return discountsMap;
    }
    
    
    /**
     * @param items - List of items supplied for Totalling
     */
    public void printCheckoutOutput(List<Item> items) {
    	BigDecimal subTotal = subtotalBasket(items);
    	System.out.println(String.format(SUBTOTAL_DESCRIPTION,  subTotal));
    	Map<String, BigDecimal> discountOutput = buildDiscountAndOutput(items);
    	discountOutput.keySet().stream().forEach(discountText -> {
	    		if (!discountOutput.get(discountText).equals(ZERO_PENCE))
	    			System.out.println(discountText);
	    	});
    	BigDecimal total = discountOutput.values().stream().reduce(ZERO_PENCE, BigDecimal::add);
    	System.out.println(String.format(TOTAL_DESCRIPTION, calculateTotalPrice(subTotal, total)));
    	System.out.println();
    }

}
