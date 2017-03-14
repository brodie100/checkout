/**
 * 
 */
package com.assignments.checkout.items;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.assignments.checkout.items.drinkable.Milk;
import com.assignments.checkout.items.edible.Apples;
import com.assignments.checkout.items.edible.Bread;
import com.assignments.checkout.items.edible.Soup;

/**
 * @author BMC
 */
@SuppressWarnings("javadoc")
public final class ItemFactory {
	
	public static final Date DATE = new Date();
	public static final double WEIGHT = 300;
	
	
	public static final String APPLES_COMP = "English Apples";
	public static final String APPLES_DESC = "Granny Smiths";
	public static final BigDecimal APPLES_PRICE = new BigDecimal(1.00).setScale(2, RoundingMode.DOWN);
	public static final double APPLES_WEIGHT = 400;
	
	public static final String BREAD_COMP = "Hovis";
	public static final String BREAD_DESC = "Super Seeded";
	public static final BigDecimal BREAD_PRICE = new BigDecimal(0.80).setScale(2, RoundingMode.DOWN);

	
	public static final String MILK_COMP = "Dale Farm";
	public static final String MILK_DESC = "1 Litre";
	public static final BigDecimal MILK_PRICE = new BigDecimal(1.30).setScale(2, RoundingMode.DOWN);
	public static final long MILK_WEIGHT = 800;
	public static final int MILK_CAPACITY = 1000;
	
	
	public static final String SOUP_COMP = "Campbells";
	public static final String SOUP_DESC = "Cream of Mushroom";
	public static final BigDecimal SOUP_PRICE = new BigDecimal(0.65).setScale(2, RoundingMode.DOWN);
	

	
	
	/**
	 * @param items - String array of items to create
	 * @return List - of newly created Items
	 * 
	 */
	public static List<Item> createItems(List<String> items) {
		return items.stream().filter(x -> itemExists(x)).map(x -> getItem(x).get()).collect(Collectors.toList());
	}
	
	/**
	 * If I had time I would probably use annotations and reflection to build the items, 
	 * possibly spring or the reflections library
	 * @param name - name of object as a string
	 * @return Item - The item or null
	 */
	private static Optional<Item> getItem(String name) {
		Optional<Item> item = Optional.empty();
		switch(name.toLowerCase()) {
			case "milk": 
				item = Optional.of(new Milk(MILK_COMP, MILK_DESC, MILK_PRICE, DATE, MILK_WEIGHT, MILK_CAPACITY));
				break;
			case "soup":
				item = 
				Optional.of(new Soup(SOUP_COMP, SOUP_DESC, SOUP_PRICE, WEIGHT, WEIGHT, DATE, DATE));
				break;
			case "apples":
				item = 
				Optional.of(new Apples(APPLES_COMP, APPLES_DESC, APPLES_PRICE, APPLES_WEIGHT, APPLES_WEIGHT, DATE, DATE, 5));
				break;
			case "bread":
				item = Optional.of(new Bread(BREAD_COMP, BREAD_DESC, BREAD_PRICE, WEIGHT, WEIGHT, DATE, DATE));
				break;
		default:
			break;
		}
		return item;
	}
	
	private static boolean itemExists(String name) {
		boolean item = false;
		switch(name.toLowerCase()) {
			case "milk": 
			case "soup":
			case "apples":
			case "bread":
				item = true;
				break;
		default:
			break;
		}
		return item;
	}
	
//	private static Item loadItem(String name) {
//		
//		Class<?> clazz = Class.forName(ItemFactory.class.getPackage().toString().concat(".").concat(name));
//		Item.class.asSubclass(clazz).;
//		
//	}
	
}
