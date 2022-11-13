package com.fypRest.enitity;

import javax.persistence.*;

@Entity
@Table(name="charity_house")
public class CharityHouse
{
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "no_of_dependents")
    private int no_of_dependents;

    @Column(name = "contact")
    private String contact;

    @Column(name = "type")
    private String type;

    @Column(name = "bank_name")
    private String bank_name;

    @Column(name = "account_no")
    private String account_no;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public CharityHouse(String name, String email, int no_of_dependents, String contact, String type, String bank_name, String account_no)
    {
        this.name = name;
        this.email = email;
        this.no_of_dependents = no_of_dependents;
        this.contact = contact;
        this.type = type;
        this.bank_name = bank_name;
        this.account_no = account_no;
    }

    public CharityHouse()
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getNo_of_dependents()
    {
        return no_of_dependents;
    }

    public void setNo_of_dependents(int no_of_dependents)
    {
        this.no_of_dependents = no_of_dependents;
    }

    public String getContact()
    {
        return contact;
    }

    public void setContact(String contact)
    {
        this.contact = contact;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getBank_name()
    {
        return bank_name;
    }

    public void setBank_name(String bank_name)
    {
        this.bank_name = bank_name;
    }

    public String getAccount_no()
    {
        return account_no;
    }

    public void setAccount_no(String account_no)
    {
        this.account_no = account_no;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "CharityHouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", no_of_dependents=" + no_of_dependents +
                ", contact='" + contact + '\'' +
                ", type='" + type + '\'' +
                ", bank_name='" + bank_name + '\'' +
                ", account_no='" + account_no + '\'' +
                '}';
    }

}