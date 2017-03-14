/**
 * 
 */
package com.assignments.checkout.items.drinkable;

import java.math.BigDecimal;
import java.util.Date;

import com.assignments.checkout.items.Item;

/**
 * @author BMC
 * 
 * Abstract class to identify objects for sale 
 */
public abstract class DrinkItem extends Item{
	
	private Date bestBeforeDate;
	private double grossWeight;
	private int millilitreCapacity;
	
	
	protected DrinkItem(String brand, String description, BigDecimal price, Date bestBeforeDate, double grossWeight, int millilitreCapacity) {
		super(brand, description, price);
		this.bestBeforeDate = bestBeforeDate;
		this.grossWeight = grossWeight;
		this.millilitreCapacity = millilitreCapacity;
	}


	/**
	 * @return Date - Best Before Date
	 */
	public Date getBestBeforeDate() {
		return this.bestBeforeDate;
	}


	/**
	 * @return double - Packaging Weight
	 */
	public double getGrossWeight() {
		return this.grossWeight;
	}


	/**
	 * @return int - Liquid Capacity in Millimetres
	 */
	public int getMillilitreCapacity() {
		return this.millilitreCapacity;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getBrand() == null) ? 0 : this.getBrand().hashCode());
        result = prime * result + ((this.getDescription() == null) ? 0 : this.getDescription().hashCode());
		result = prime * result + ((this.bestBeforeDate == null) ? 0 : this.bestBeforeDate.hashCode());
		result = prime * result + ((this.getPrice() == null) ? 0 : this.getPrice().hashCode());
		long temp;
		temp = Double.doubleToLongBits(this.grossWeight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + this.millilitreCapacity;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DrinkItem item = (DrinkItem) obj;
		if (this.bestBeforeDate == null) {
			if (item.bestBeforeDate != null)
				return false;
		} else if (!this.bestBeforeDate.equals(item.bestBeforeDate))
			return false;
		if (this.getPrice() == null) {
			if (item.getPrice() != null)
				return false;
		} else if (!this.getPrice().equals(item.getPrice()))
			return false;
		if (Double.doubleToLongBits(this.grossWeight) != Double.doubleToLongBits(item.grossWeight))
			return false;
		if (this.millilitreCapacity != item.millilitreCapacity)
			return false;
		return true;
	}
	
	
	
}
