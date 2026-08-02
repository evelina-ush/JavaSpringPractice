package org.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name="\"Suppliers\"")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String inn;

    private String country;

    private String city;

    private String street;

    private String phone;

    private String email;


    public Supplier(){

    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getInn(){
        return inn;
    }

    public void setInn(String inn){
        this.inn = inn;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getStreet(){
        return street;
    }

    public void setStreet(){
        this.street = street;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
