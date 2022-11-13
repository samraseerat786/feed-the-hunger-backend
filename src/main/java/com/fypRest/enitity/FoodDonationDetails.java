package com.fypRest.enitity;

import javax.persistence.*;

@Entity
@Table(name="food_donation_details")
public class FoodDonationDetails
{
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="quantity_value")
    private int quantityValue;

    @Column(name="quantity_unit")
    private String quantityUnit;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "food_item_id")
    private FoodItem foodItem;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "donation_id")
    private Donation donation;

    public FoodDonationDetails()
    {
    }

    public FoodDonationDetails(int quantityValue, String quantityUnit, FoodItem foodItem, Donation donation)
    {
        this.quantityValue = quantityValue;
        this.quantityUnit = quantityUnit;
        this.foodItem = foodItem;
        this.donation = donation;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getQuantityValue()
    {
        return quantityValue;
    }

    public void setQuantityValue(int quantityValue)
    {
        this.quantityValue = quantityValue;
    }

    public String getQuantityUnit()
    {
        return quantityUnit;
    }

    public void setQuantityUnit(String quantityUnit)
    {
        this.quantityUnit = quantityUnit;
    }

    public FoodItem getFoodItem()
    {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem)
    {
        this.foodItem = foodItem;
    }

    public Donation getDonation()
    {
        return donation;
    }

    public void setDonation(Donation donation)
    {
        this.donation = donation;
    }

    @Override
    public String toString()
    {
        return "FoodDonationDetails{" +
                "id=" + id +
                ", quantityValue=" + quantityValue +
                ", quantityUnit='" + quantityUnit + '\'' +
                ", foodItem=" + foodItem +
                ", donation=" + donation +
                '}';
    }
}
