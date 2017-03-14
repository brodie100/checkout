/**
 * 
 */
package com.assignments.checkout.items.edible;

import java.math.BigDecimal;
import java.util.Date;

import com.assignments.checkout.items.Item;

/**
 * @author BMC
 * 
 * Abstract class to identify Food items for sale 
 */
public abstract class FoodItem extends Item {
    
    private final double grossWeight;
    private final double netWeight;
    private final Date expiryDate;
    private final Date bestBeforeDate;
    
    protected FoodItem(String brand, 
            String description, 
            BigDecimal price, 
            double netWeight, 
            double grossWeight,
            Date bestBeforeDate,
            Date expiryDate) {
        super(brand, description, price);
        this.bestBeforeDate = bestBeforeDate;
        this.expiryDate = expiryDate;
        this.grossWeight = grossWeight;
        this.netWeight = netWeight;
        
    }
    
    
    /**
     * @return double - Weight of item with Packaging
     */
    public double getGrossWeight() {
        return this.grossWeight;
    }
    
    /**
     * @return Weight of item without Packaging
     */
    public double getNetWeight() {
        return this.netWeight;
    }
    
    /**
     * @return Date - Expiry Date
     */
    public Date getExpiryDate() {
        return this.expiryDate;
    }
    
    /**
     * @return Date - Best Before Date
     */
    public Date getBestBeforeDate() {
        return this.bestBeforeDate;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FoodItem item = (FoodItem) obj;
        if (null == this.getBrand()) {
            if (null != item.getBrand())
                return false;
        } else if (!this.getBrand().equals(item.getBrand())) {
            return false;
        }
        if (null == this.getDescription()) {
            if (null != item.getDescription())
                return false;
        } else if (!this.getDescription().equals(item.getDescription())) {
                return false;
        }
        if (this.getPrice() == null) {
			if (item.getPrice() != null)
				return false;
		} else if (!this.getPrice().equals(item.getPrice()))
			return false;
        
        if (null == this.bestBeforeDate) {
            if (null != item.bestBeforeDate)
                return false;
        } else if (!this.bestBeforeDate.equals(item.bestBeforeDate)) {
            return false;
        }
        if (this.expiryDate == null) {
            if (item.expiryDate != null)
                return false;
        } else if (!this.expiryDate.equals(item.expiryDate)) {
            return false;
        }
        
        if (Double.doubleToLongBits(this.grossWeight) != Double.doubleToLongBits(item.grossWeight))
            return false;
        if (Double.doubleToLongBits(this.netWeight) != Double.doubleToLongBits(item.netWeight))
            return false;
        return true;
    }

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.getBrand() == null) ? 0 : this.getBrand().hashCode());
        result = prime * result + ((this.getDescription() == null) ? 0 : this.getDescription().hashCode());
        result = prime * result + ((this.bestBeforeDate == null) ? 0 : this.bestBeforeDate.hashCode());
        result = prime * result + ((this.expiryDate == null) ? 0 : this.expiryDate.hashCode());
        result = prime * result + ((this.getPrice() == null) ? 0 : this.getPrice().hashCode());
        long temp;
        temp = Double.doubleToLongBits(this.grossWeight);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(this.netWeight);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
    
}
