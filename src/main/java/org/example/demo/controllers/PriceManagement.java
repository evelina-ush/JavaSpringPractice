package org.example.demo.controllers;

import jakarta.persistence.Id;
import org.example.demo.dtos.ProductDTO;
import org.example.demo.models.Product;
import org.example.demo.repositories.ProductRepository;
import org.example.demo.services.ProductPriceService;
import org.example.demo.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/product-management")
public class PriceManagement {

    private final ProductPriceService priceService;
    private final ProductService productService;
    private final ProductRepository productRepo;

    public PriceManagement(ProductPriceService priceService, ProductService productService, ProductRepository productRepo) {
        this.priceService = priceService;
        this.productService = productService;
        this.productRepo = productRepo;
    }

    @GetMapping("/products")
    public Map<String, Object> getAllProducts() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<Product> products = productRepo.findAll();
            response.put("success", true);
            response.put("information", products);
        } catch (Exception e) {
            response.put("success", false);
            response.put("information", List.of());
            response.put("message", e.getMessage());
        }
        return response;
    }

    @PostMapping("/products/{id}/price")
    public Map<String, Object> updatePrice(@PathVariable Integer id,
                                           @RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();
        try {
            BigDecimal newPrice = new BigDecimal(request.get("newPrice").toString());

            priceService.changePriceAndSaveHistory(id, newPrice);

            response.put("success", true);
            response.put("message", "Цена успешно обновлена");
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Ошибка: " + e.getMessage());
        }
        return response;
    }
}