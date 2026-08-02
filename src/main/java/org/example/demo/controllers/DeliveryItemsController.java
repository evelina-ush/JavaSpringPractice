package org.example.demo.controllers;

import org.example.demo.dtos.DeliveryItemResponse;
import org.example.demo.models.DeliveryItem;
import org.example.demo.repositories.DeliveryItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@RestController
public class DeliveryItemsController {

    private final DeliveryItemRepository deliveryRepo;

    public DeliveryItemsController(DeliveryItemRepository deliveryRepo) {
        this.deliveryRepo = deliveryRepo;
    }

    @GetMapping("supply-management/supplies")
    public Map<String, Object> getAllDeliveryItems() {
        List<DeliveryItem> items = deliveryRepo.findAll();

        List<DeliveryItemResponse> dtos = items.stream().map(DeliveryItemResponse::from).toList();

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("information", dtos);

        return response;
    }
}
