package org.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Customer\"")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 300, nullable = false)
    private String name;

    @Column(name = "country", length = 100, nullable = false)
    private String country;

    @Column(name = "city", length = 100, nullable = false)
    private String city;

    @Column(name = "street", length = 150, nullable = false)
    private String street;

    @Column(name = "house", length = 10, nullable = false)
    private String house;

    @Column(name = "inn", length = 100, nullable = false)
    private String inn;


    public Customer() {}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }
}