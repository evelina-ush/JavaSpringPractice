package org.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name="\"AmountIn\"")
public class AmountIn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String metric;

    public AmountIn(){

    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getMetric(){
        return metric;
    }

    public void setMetric(String unit){
        this.metric = unit;
    }
}
