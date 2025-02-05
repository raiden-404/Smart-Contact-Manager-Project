package com.contactmanager.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


//Declaring it as entity
@Entity
@Table(name = "CONTACT")
public class Contact {
    //ContectID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cId;

    //Contact-FirstName
    private String firstName;

    //Contact-LastName
    private String lastName;
    
    //Contact work mode
    private String work;
    
    //Contact email
    private String email;
    
    //Contact Phone Number
    private String phone;
    
    //Contact ImageUrl
    private String image;
    
    //Contact Discription section
    @Column(length = 1000)
    private String descritption;

    @ManyToOne
    private User user;

    //Getters And Setters
    
    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescritption() {
        return descritption;
    }

    public void setDescritption(String descritption) {
        this.descritption = descritption;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //Constructors

    public Contact(int cId, String firstName, String lastName, String work, String email, String phone, String image,
            String descritption) {
        this.cId = cId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.work = work;
        this.email = email;
        this.phone = phone;
        this.image = image;
        this.descritption = descritption;
    }

    public Contact() {
    }


}
