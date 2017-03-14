/**
 * 
 */
package com.assignments.checkout.constants;

import java.math.BigDecimal;

/**
 * @author BMC
 *
 */
@SuppressWarnings("javadoc")
public enum Discounts {

    TEN_PERCENT(BigDecimal.valueOf(10), "10%"),
    TWENTY_PERCENT(BigDecimal.valueOf(20), "20%"),
    THIRTY_PERCENT(BigDecimal.valueOf(30), "30%"),
    FOURTY_PERCENT(BigDecimal.valueOf(40), "40%"),
    FIFTY_PERCENT(BigDecimal.valueOf(50), "50%"),
    SIXTY_PERCENT(BigDecimal.valueOf(60), "60%"),
    SEVENTY_PERCENT(BigDecimal.valueOf(70), "70%"),
    EIGHTY_PERCENT(BigDecimal.valueOf(80), "80%"),
    NINETY_PERCENT(BigDecimal.valueOf(90), "90%"),
	BOGOF(BigDecimal.valueOf(100), "100%");
    
    private BigDecimal percentage; 
    
    private String description;
    
    private Discounts(BigDecimal percentage, String description) {
        this.percentage = percentage;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
    
    /**
     * @return BigDecimal - integer value of percent discount applies to.
     */
    public BigDecimal getDiscount() {
    	return this.percentage;
    }
    
    
}
