package com.bellesofthebar.repository;

import com.bellesofthebar.model.Booking;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookingRepositoryTests {

    @Autowired
    private BookingRepository bookingRepository;

    @Test
    public void testSaveAndFindAll() {
        // Given
        Booking booking = new Booking();
        booking.setDate(LocalDateTime.now());
        bookingRepository.save(booking);

        // When
        List<Booking> bookings = bookingRepository.findAll();

        // Then
        assertThat(bookings).isNotEmpty();
        assertThat(bookings).contains(booking);
    }

    @Test
    public void testDelete() {
        // Given
        Booking booking = new Booking();
        booking.setDate(LocalDateTime.now());
        bookingRepository.save(booking);

        // When
        bookingRepository.delete(booking);
        List<Booking> bookings = bookingRepository.findAll();

        // Then
        assertThat(bookings).doesNotContain(booking);
    }
}