package com.bellesofthebar.repository;

import com.bellesofthebar.model.Event;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class EventRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EventRepository eventRepository;

    @Test
    public void testFindByLocation() {
        // Create a valid Event object
        Event event = new Event();
        event.setEventName("Test Event");
        event.setLocation("Test Location");
        event.setEventDate(LocalDate.now().plusDays(1)); // Set to a future date
        event.setGuestCount(50); // Set a valid guest count
        entityManager.persist(event);
        entityManager.flush();

        List<Event> foundEvents = eventRepository.findByLocation("Test Location");
        assertFalse(foundEvents.isEmpty());
        assertEquals("Test Location", foundEvents.get(0).getLocation());
    }

    @Test
    public void testFindByEventDateBetween() {
        // Create valid Event objects
        Event event1 = new Event();
        event1.setEventName("Event 1");
        event1.setLocation("Location 1");
        event1.setEventDate(LocalDate.now().plusDays(5));
        event1.setGuestCount(100);
        entityManager.persist(event1);

        Event event2 = new Event();
        event2.setEventName("Event 2");
        event2.setLocation("Location 2");
        event2.setEventDate(LocalDate.now().plusDays(10));
        event2.setGuestCount(200);
        entityManager.persist(event2);

        entityManager.flush();

        LocalDate startDate = LocalDate.now().plusDays(4);
        LocalDate endDate = LocalDate.now().plusDays(11);
        List<Event> foundEvents = eventRepository.findByEventDateBetween(startDate, endDate);

        assertEquals(2, foundEvents.size());
    }

    @Test
    public void testFindEventsWithGuestCountGreaterThan() {
        // Create valid Event objects
        Event event1 = new Event();
        event1.setEventName("Small Event");
        event1.setLocation("Location 1");
        event1.setEventDate(LocalDate.now().plusDays(1));
        event1.setGuestCount(50);
        entityManager.persist(event1);

        Event event2 = new Event();
        event2.setEventName("Large Event");
        event2.setLocation("Location 2");
        event2.setEventDate(LocalDate.now().plusDays(2));
        event2.setGuestCount(150);
        entityManager.persist(event2);

        entityManager.flush();

        List<Event> foundEvents = eventRepository.findEventsWithGuestCountGreaterThan(100);

        assertEquals(1, foundEvents.size());
        assertEquals("Large Event", foundEvents.get(0).getEventName());
    }
}