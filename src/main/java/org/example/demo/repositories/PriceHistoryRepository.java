package org.example.demo.repositories;

import org.example.demo.models.PriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceHistoryRepository extends JpaRepository<PriceHistory, Integer> {

}
