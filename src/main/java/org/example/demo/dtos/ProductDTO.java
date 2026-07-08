package org.example.demo.dtos;

import org.example.demo.models.Product;

import java.math.BigDecimal;

public record ProductDTO(
        Integer id,
        String name,
        BigDecimal price,
        String metricName,
        String supplierName
) {
    public static ProductDTO from(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getMetric() != null ? product.getMetric().getMetric() : null,
                product.getSupplier() != null ? product.getSupplier().getName() : null
        );
    }
}