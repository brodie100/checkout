/**
 * 
 */
package com.assignments.checkout.items;

import java.math.BigDecimal;

import com.assignments.checkout.items.drinkable.DrinkItem;
import com.assignments.checkout.items.edible.FoodItem;

/**
 * @author BMC
 * 
 * Generic class to identify objects for sale, shown as an example of handling items
 * Food, Drink or other.  
 * 
 */
public abstract class Item {
    
    private BigDecimal price;
    private String description;
    private String brand;

    protected Item(String brand, String description, BigDecimal price) {
        this.brand = brand;
        this.description = description;
        this.price = price;
        
    }
    
    
    @Override
    public abstract int hashCode();


    @Override
    public abstract boolean equals(Object obj);
    

    /**
     * @return boolean - indicating if the item is a food item
     */
    public boolean isEdible(){
        return this instanceof FoodItem;
    }
    
    /**
     * @return boolean - indicating if the item is a drink item
     */
    public boolean isDrinkable(){
        return this instanceof DrinkItem;
    }

    /**
     * @return double - The items price
     */
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * @return String - Text description of the item
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @return String Manufacturer brand
     */
    public String getBrand() {
        return this.brand;
    }

}
