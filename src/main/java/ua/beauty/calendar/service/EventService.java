package ua.beauty.calendar.service;





//это порт


import ua.beauty.calendar.domain.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {

    List<Event> findAll();

    Optional<Event> findById(Long id);

    Long addEvent(Event event);

    Long removeEvent(Long id);

}
