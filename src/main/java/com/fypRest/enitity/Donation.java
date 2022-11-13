package com.fypRest.enitity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="donation")
public class Donation
{
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "donner_id")
    private Donner donner;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "charity_house_id")
    private CharityHouse charityHouse;

    public Donation()
    {
    }

    public Donation(Date date, Donner donner, CharityHouse charityHouse)
    {
        this.date = date;
        this.donner = donner;
        this.charityHouse = charityHouse;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Donner getDonner()
    {
        return donner;
    }

    public void setDonner(Donner donner)
    {
        this.donner = donner;
    }

    public CharityHouse getCharityHouse()
    {
        return charityHouse;
    }

    public void setCharityHouse(CharityHouse charityHouse)
    {
        this.charityHouse = charityHouse;
    }

    @Override
    public String toString()
    {
        return "Donation{" +
                "id=" + id +
                ", date=" + date +
                ", donner=" + donner +
                ", charityHouse=" + charityHouse +
                '}';
    }
}
