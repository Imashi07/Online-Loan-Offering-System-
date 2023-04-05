package com.example.bumblebee.repositories;

import com.example.bumblebee.entity.InstallmentPlans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstallmentPlanRepo extends JpaRepository<InstallmentPlans, Long> {
}
