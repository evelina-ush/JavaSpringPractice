package org.example.demo.dtos;

import org.example.demo.models.DeliveryItem;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DeliveryItemResponse(
        Integer id,
        Double amountOfProduct,
        BigDecimal pricePaid,

        String productName,

        String customerName,

        LocalDate contractDate,

        String customerCity
) {
    public static DeliveryItemResponse from(DeliveryItem item) {
        return new DeliveryItemResponse(
                item.getId(),
                item.getAmountOfProduct(),
                item.getPricePaid(),

                item.getProduct() != null ? item.getProduct().getName() : null,

                item.getDelivery() != null && item.getDelivery().getCustomer() != null
                        ? item.getDelivery().getCustomer().getName() : null,

                item.getDelivery() != null ? item.getDelivery().getContractDate() : null,

                item.getDelivery() != null && item.getDelivery().getCustomer() != null
                        ? item.getDelivery().getCustomer().getCity() : null
        );
    }
}
