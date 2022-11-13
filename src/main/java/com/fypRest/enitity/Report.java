package com.fypRest.enitity;

import javax.persistence.*;

@Entity
@Table(name = "report")
public class Report
{
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="type")
    private String type;

    @Column(name="email")
    private String email;

    @Column(name="message")
    private String message;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "donners_id")
    private Donner donner;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "charity_houses_id")
    private CharityHouse charityHouse;

    public Report(String type, String email, String message)
    {
        this.type = type;
        this.email = email;
        this.message = message;
    }

    public Report()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
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
        return "Report{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", emial='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
