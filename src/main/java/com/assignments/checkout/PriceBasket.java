package com.assignments.checkout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.assignments.checkout.constants.Discounts;
import com.assignments.checkout.constants.Function;
import com.assignments.checkout.discounts.Discount;
import com.assignments.checkout.discounts.DiscountBuyManyGetDiffItemHalfPrice;
import com.assignments.checkout.discounts.DiscountPercentage;
import com.assignments.checkout.exceptions.InvalidFunctionException;
import com.assignments.checkout.items.Item;
import com.assignments.checkout.items.edible.Apples;
import com.assignments.checkout.items.edible.Bread;
import com.assignments.checkout.items.edible.Soup;
import com.assignments.checkout.services.CheckoutService;
import com.assignments.checkout.services.InputService;

/**
 * Main Application
 *
 */
public class PriceBasket {
	private static final String PROMPT = "Please Specify a command and items to Price: ";
	
	private static CheckoutService service;

    /**
     * @param args - This Main method does not need arguments at instantiation
     */
    public static void main(String[] args ) {
    	if (!Arrays.asList(args).contains("noOffers"))
    		service = new CheckoutService(Optional.of(PriceBasket.curentDiscounts()));
    	else
    		service = new CheckoutService(Optional.empty());
    	
        try (Scanner input = new Scanner(System.in)) {
            System.out.println(PROMPT);
            while (input.hasNextLine()) {
                processInput(input.nextLine());
                System.out.println(PROMPT);
            }
        } catch (InvalidFunctionException e) {
            /*
             * Chose to exit application if invalid/no command is expressed.  
             * Could have let the program continue by handling it in the while loop
             */
        	
            e.printStackTrace();
        }
    }  
    
    
    private static void processInput(String args) throws InvalidFunctionException {
    	String [] argsList = args.split("\\s+");
        Function enteredFunction = InputService.getValidFunctionCall(argsList);
        List<Item> items = InputService.getItemsFromArguments(argsList);
        
        switch(enteredFunction) {
            case PRICE_BASKET:
                service.printCheckoutOutput(items);
                break;
            default:
                throw new UnsupportedOperationException("Unkown Input for processing");
        }
        
    }
    
    private static List<Discount> curentDiscounts() {
    	List<Discount> discounts = new ArrayList<>();
    	discounts.add(new DiscountBuyManyGetDiffItemHalfPrice("Bread 50% off", Bread.class, Soup.class, 2));
    	discounts.add(new DiscountPercentage("Apples 10% off", Apples.class, Discounts.TEN_PERCENT));
    	
    	return discounts;
    }
}
