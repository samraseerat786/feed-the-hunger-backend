package com.fypRest.enitity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="donner")
public class Donner
{
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "address")
    private String address;

    @Column(name = "contact")
    private String contact;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "_user_id")
    private User user;

    public Donner()
    {
    }

    public Donner(String address, String contact, User user)
    {
        this.address = address;
        this.contact = contact;
        this.user = user;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getContact()
    {
        return contact;
    }

    public void setContact(String contact)
    {
        this.contact = contact;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "Donner{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", user=" + user +
                '}';
    }
}