package com.bellesofthebar.controller;

import com.bellesofthebar.model.Booking;
import com.bellesofthebar.model.Service;
import com.bellesofthebar.service.BookingService;
import com.bellesofthebar.service.ServiceService;
import com.bellesofthebar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @Autowired
    private ServiceService serviceService;

    @GetMapping("/new")
    public String showBookingForm(Model model) {
        Booking booking = new Booking();
        List<Service> services = serviceService.getAllServices();
        model.addAttribute("booking", booking);
        model.addAttribute("services", services);
        return "booking-form";
    }

    @PostMapping("/new")
    public String createBooking(@ModelAttribute Booking booking, Principal principal) {
        booking.setUser(userService.getUserByUsername(principal.getName()));
        bookingService.createBooking(booking);
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String viewBookings(Model model, Principal principal) {
        model.addAttribute("bookings", bookingService.getAllBookings());
        return "dashboard";
    }
}
