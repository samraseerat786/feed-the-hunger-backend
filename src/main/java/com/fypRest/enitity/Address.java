package com.fypRest.enitity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "street_address")
    private String streetAddress;

    @JoinColumn(name = "city")
    private String city;

    @JoinColumn(name = "zip_code")
    private int zipCode;

    @JoinColumn(name = "state")
    private String state;

    @JoinColumn(name = "country")
    private String country;

    public Address()
    {
    }

    public Address(String streetAddress, String city, int zipCode, String state, String country)
    {
        this.streetAddress = streetAddress;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getStreetAddress()
    {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress)
    {
        this.streetAddress = streetAddress;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public int getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(int zipCode)
    {
        this.zipCode = zipCode;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    @Override
    public String toString()
    {
        return "Address{" +
                "id=" + id +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
