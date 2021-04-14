package com.example.changeit.model;

public class User {
    private String name;
    private String email;
    private String phoneNumber;
    private Apartment apartmentAd;
    private String password;
    //bild

   public User(String name, String email, String phoneNumber, String password){
        this.name=name;
        this.email=email;
        this.phoneNumber= phoneNumber;
        this.password= password;
    }

    public void addApartmentAd(Apartment apartmentAd){
        this.apartmentAd=apartmentAd;
    }

    public String getName() {
       return name;
    }

    public String getPhoneNumber(){
       return phoneNumber;
    }


    public String getEmail(){
       return email;
    }

    //setters,getters, ändra namn osv.... TODO



}
