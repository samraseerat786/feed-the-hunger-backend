package com.fypRest.enitity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="food_item")
public class FoodItem
{
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="expiry_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date expiry_date;

    @Column(name="type")
    private String type;
     private String image;

    public FoodItem()
    {
    }

    public FoodItem(int id, String name, Date expiry_date, String type, String image) {
        this.id = id;
        this.name = name;
        this.expiry_date = expiry_date;
        this.type = type;
        this.image = image;
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

    public Date getExpiry_date()
    {
        return expiry_date;
    }

    public void setExpiry_date(Date expiry_date)
    {
        this.expiry_date = expiry_date;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", expiry_date=" + expiry_date +
                ", type='" + type + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
