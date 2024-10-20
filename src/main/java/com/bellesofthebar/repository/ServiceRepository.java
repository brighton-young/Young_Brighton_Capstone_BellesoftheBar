package com.bellesofthebar.repository;

import com.bellesofthebar.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    List<Service> findByServiceNameContaining(String name);
    List<Service> findByPricePerHourLessThan(double price);
}