package com.bellesofthebar.controller;

import com.bellesofthebar.model.Service;
import com.bellesofthebar.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping("/new")
    public String showServiceForm(Model model) {
        model.addAttribute("service", new Service());
        return "service-form";
    }

    @PostMapping("/new")
    public String createService(@ModelAttribute Service service) {
        serviceService.createService(service);
        return "redirect:/services";
    }

    @GetMapping
    public String viewServices(Model model) {
        model.addAttribute("services", serviceService.getAllServices());
        return "services";
    }
}
