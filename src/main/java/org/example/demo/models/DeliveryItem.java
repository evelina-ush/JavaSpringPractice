package org.example.demo.models;

import jakarta.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "\"DeliveryItems\"")
public class DeliveryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id", nullable = false)
    private DeliveryItself delivery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "amount_of_product", nullable = false)
    private Double amountOfProduct;

    @Column(name = "price_paid", precision = 10, scale = 2, nullable = false)
    private BigDecimal pricePaid;

    public DeliveryItem() {}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DeliveryItself getDelivery() {
        return delivery;
    }

    public void setDelivery(DeliveryItself delivery) {
        this.delivery = delivery;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getAmountOfProduct() {
        return amountOfProduct;
    }

    public void setAmountOfProduct(Double amountOfProduct) {
        this.amountOfProduct = amountOfProduct;
    }

    public BigDecimal getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(BigDecimal pricePaid) {
        this.pricePaid = pricePaid;
    }
}