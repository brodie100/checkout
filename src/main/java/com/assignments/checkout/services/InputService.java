/**
 * 
 */
package com.assignments.checkout.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.assignments.checkout.constants.Function;
import com.assignments.checkout.exceptions.InvalidFunctionException;
import com.assignments.checkout.items.Item;
import com.assignments.checkout.items.ItemFactory;

/**
 * @author BMC
 *
 */
public final class InputService {

	/**
	 * Returns the Function to apply.  
	 * Looks through all input values and returns the function specified.
	 * It throws an exception if there none or too many functions specified in text.
	 * 
	 * @param args - List of args to filter and find the Function in the input list
	 * @return Function - The enum of the Function returned
	 * @throws InvalidFunctionException - Exactly one function is allowed to be specified
	 */
	public static Function getValidFunctionCall(String... args) throws InvalidFunctionException {
    	List<String> enteredFunctions = filterArgs(true, args);
    			
    	if (1 == enteredFunctions.size()) 
    		return Function.returnFunction(enteredFunctions.get(0));
    	throw new InvalidFunctionException();
    }
	
	
    /**
     * @param args - String array of input arguments to filter into Items
     * @return List<Items> - List of Items filtered from Output
     */
    public static List<Item> getItemsFromArguments(String... args) {
    	List<Item> items = ItemFactory.createItems(filterArgs(false, args));
    	return items;
    }
    

    private static List<String> filterArgs(boolean returnFunctions, String... args){
    	return Arrays.stream(args)
    			.filter(x -> Function.isValidFunction(x) == returnFunctions)
    			.collect(Collectors.toList());
    }
}
