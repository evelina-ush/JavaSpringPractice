package org.example.demo.repositories;

import org.example.demo.models.DeliveryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryItemRepository extends JpaRepository<DeliveryItem, Integer> {
}
