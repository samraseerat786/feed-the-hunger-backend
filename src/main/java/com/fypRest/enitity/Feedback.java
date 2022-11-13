package com.fypRest.enitity;

import javax.persistence.*;

@Entity
@Table(name="Feedback")
public class Feedback
{
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="email")
    private String email;

    @Column(name="subject")
    private String subject;

    @Column(name="feedback_message")
    private String feedbackMessage;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "donners_id")
    private Donner donner;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "charity_id")
    private CharityHouse charityHouse;

    public Feedback()
    {

    }

    public Feedback(String email, String subject, String feedbackMessage, Donner donner, CharityHouse charityHouse)
    {
        this.email = email;
        this.subject = subject;
        this.feedbackMessage = feedbackMessage;
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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public String getFeedbackMessage()
    {
        return feedbackMessage;
    }

    public void setFeedbackMessage(String feedbackMessage)
    {
        this.feedbackMessage = feedbackMessage;
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
        return "Feedback{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", feedbackMessage='" + feedbackMessage + '\'' +
                ", donner=" + donner +
                ", charityHouse=" + charityHouse +
                '}';
    }
}
