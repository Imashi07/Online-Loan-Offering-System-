package com.example.bumblebee.repositories;

import com.example.bumblebee.entity.PurchaseLoanOrders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseLoanOrderRepo extends JpaRepository<PurchaseLoanOrders, Long> {
}
