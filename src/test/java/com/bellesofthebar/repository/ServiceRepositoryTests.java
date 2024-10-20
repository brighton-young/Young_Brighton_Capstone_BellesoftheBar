package com.bellesofthebar.repository;

import com.bellesofthebar.model.Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ServiceRepositoryTests {

    @Autowired
    private ServiceRepository serviceRepository;

    @Test
    public void testFindByServiceNameContaining() {
        // Given
        Service service1 = new Service();
        service1.setServiceName("Cleaning Service");
        service1.setDescription("Thorough cleaning");
        service1.setPricePerHour(50);
        serviceRepository.save(service1);

        Service service2 = new Service();
        service2.setServiceName("Catering Service");
        service2.setDescription("Delicious meals for events");
        service2.setPricePerHour(75);
        serviceRepository.save(service2);

        // When
        List<Service> services = serviceRepository.findByServiceNameContaining("Service");

        // Then
        assertThat(services).isNotEmpty();
        assertThat(services).contains(service1, service2);
    }

    @Test
    public void testFindByPricePerHourLessThan() {
        // Given
        Service service1 = new Service();
        service1.setServiceName("Budget Cleaning");
        service1.setDescription("Affordable cleaning");
        service1.setPricePerHour(30);
        serviceRepository.save(service1);

        Service service2 = new Service();
        service2.setServiceName("Premium Catering");
        service2.setDescription("High-end meals for events");
        service2.setPricePerHour(150);
        serviceRepository.save(service2);

        // When
        List<Service> services = serviceRepository.findByPricePerHourLessThan(100);

        // Then
        assertThat(services).isNotEmpty();
        assertThat(services).contains(service1);
        assertThat(services).doesNotContain(service2);
    }
}