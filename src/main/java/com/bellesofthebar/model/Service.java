package com.bellesofthebar.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;
    private String description;
    private double pricePerHour;

    @ManyToMany(mappedBy = "services")
    private List<Booking> bookings;

    // Getters and Setters
}
