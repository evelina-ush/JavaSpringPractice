package org.example.demo.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="\"Product\"")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="metric_id")
    private AmountIn metric;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="supplier_id")
    private Supplier supplier;

    public Product(){

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

    public BigDecimal getPrice(){
        return price;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public AmountIn getMetric() {
        return metric;
    }

    public void setMetric(AmountIn unit){
        this.metric = unit;
    }

    public Supplier getSupplier(){
        return supplier;
    }

    public void setSupplier(Supplier newSupplier){
        this.supplier = newSupplier;
    }
}
