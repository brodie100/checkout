/**
 * 
 */
package com.assignments.checkout.constants;

/**
 * @author BMC
 * Enums representing the function used on the command line
 */
public enum Function {
	/**
	 * Only One type of function which is totalling the basket.  
	 * This could be extended for price checks etc.
	 */
	PRICE_BASKET("PriceBasket"),
	/**
	 * Ran out of time for this one
	 */
	PRICE_BASKET_REFLECTION("PriceBasketReflection");
	
	private final String text;
	
	Function(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return this.text;
	}
	
	/**
	 * @param text - text name of function enum
	 * @return boolean - representing if the text passed in relates to a real function
	 */
	public static boolean isValidFunction(String text) {
        for (Function function : Function.values())
            if (function.text.equals(text))
                return true;
       return false;
	}
	
	/**
	 * @param text - text name of function enum
	 * @return function - represents the function enum of the text passed in
	 */
	public static Function returnFunction(String text) {
        for (Function function : Function.values())
            if (function.text.equals(text))
                return function;
       return null;
	}
	
}
