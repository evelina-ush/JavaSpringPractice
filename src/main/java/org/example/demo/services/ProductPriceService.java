package org.example.demo.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.example.demo.models.PriceHistory;
import org.example.demo.models.Product;
import org.example.demo.repositories.PriceHistoryRepository;
import org.example.demo.repositories.ProductRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@Transactional
public class ProductPriceService {

    private final ProductRepository productRepo;
    private final PriceHistoryRepository priceHistoryRepo;

    public ProductPriceService(ProductRepository productRepo,
                               PriceHistoryRepository priceHistoryRepo) {
        this.productRepo = productRepo;
        this.priceHistoryRepo = priceHistoryRepo;
    }

    public void changePriceAndSaveHistory(Integer id, BigDecimal newPrice) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Не найдена сущность с указанным id:" + id));

        if (!isValidPrice(newPrice)) {
            throw new IllegalArgumentException("Товары не могут быть бесплатными, доплачивать покупателям возможности не имеем");
        }

        PriceHistory priceHistory = new PriceHistory();
        priceHistory.setProduct(product);
        priceHistory.setOldPrice(product.getPrice());
        priceHistory.setNewPrice(newPrice);
        priceHistory.setChangedAt(LocalDateTime.now());
        priceHistory.setChangedBy("Система");

        product.setPrice(newPrice);

        priceHistoryRepo.save(priceHistory);
        productRepo.save(product);
    }

    private boolean isValidPrice(BigDecimal price) {
        return price != null && price.compareTo(BigDecimal.ZERO) > 0;
    }
}
