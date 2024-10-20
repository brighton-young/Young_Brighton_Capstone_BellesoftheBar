package com.bellesofthebar.repository;

import com.bellesofthebar.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    // Custom query methods
    List<Event> findByLocation(String location);

    List<Event> findByEventDateBetween(LocalDate startDate, LocalDate endDate);

    // Named query using JPQL
    @Query("SELECT e FROM Event e WHERE e.guestCount > :guestCount")
    List<Event> findEventsWithGuestCountGreaterThan(@Param("guestCount") int guestCount);
}