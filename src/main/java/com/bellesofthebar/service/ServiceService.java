package com.bellesofthebar.service;

import com.bellesofthebar.model.Service;
import com.bellesofthebar.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public Service createService(Service service) {
        return serviceRepository.save(service);
    }

    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    public void deleteService(Long serviceId) {
        serviceRepository.deleteById(serviceId);
    }
}