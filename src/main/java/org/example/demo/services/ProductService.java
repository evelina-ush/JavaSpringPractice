package org.example.demo.services;


import jakarta.transaction.Transactional;
import org.example.demo.dtos.ProductDTO;
import org.example.demo.repositories.PriceHistoryRepository;
import org.example.demo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepo;
    private final PriceHistoryRepository priceHistoryRepo;

    public ProductService(ProductRepository productRepo,
                               PriceHistoryRepository priceHistoryRepo) {
        this.productRepo = productRepo;
        this.priceHistoryRepo = priceHistoryRepo;
    }

    public List<ProductDTO> getAllProductsForManagement() {
        return productRepo.findAll().stream()
                .map(ProductDTO::from)
                .toList();
    }

}
