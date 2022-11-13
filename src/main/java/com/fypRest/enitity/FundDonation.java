package com.fypRest.enitity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="fund_donation")
public class FundDonation
{
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="amount")
    private int amount;

    @Column(name="currency")
    private String currency;

    @Column(name="donner_card")
    private String donnerCard;

    @Column(name="card_expiry_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private String cardExpiryDate;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "_donation_id")
    private Donation donation;

    public FundDonation()
    {
    }

    public FundDonation(int amount, String currency, String donnerCard, String cardExpiryDate, Donation donation)
    {
        this.amount = amount;
        this.currency = currency;
        this.donnerCard = donnerCard;
        this.cardExpiryDate = cardExpiryDate;
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

    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public String getDonnerCard()
    {
        return donnerCard;
    }

    public void setDonnerCard(String donnerCard)
    {
        this.donnerCard = donnerCard;
    }

    public String getCardExpiryDate()
    {
        return cardExpiryDate;
    }

    public void setCardExpiryDate(String cardExpiryDate)
    {
        this.cardExpiryDate = cardExpiryDate;
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
        return "FundDonation{" +
                "id=" + id +
                ", amount=" + amount +
                ", currency=" + currency +
                ", donnerCard='" + donnerCard + '\'' +
                ", cardExpiryDate='" + cardExpiryDate + '\'' +
                ", donation=" + donation +
                '}';
    }
}

