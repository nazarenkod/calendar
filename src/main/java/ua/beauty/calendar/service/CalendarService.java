package ua.beauty.calendar.service;

import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import ua.beauty.calendar.api.CalendarController;
import ua.beauty.calendar.domain.CalendarEvent;
import ua.beauty.calendar.domain.dto.EventRequest;


import java.util.List;
import java.util.Map;




//это порт


public interface CalendarService {

    CalendarEvent addEvents(EventRequest request);

    List<Event> getAllEvents();

    List<CalendarEvent> getEventsByMaster(String master);
}
