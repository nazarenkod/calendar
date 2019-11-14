package ua.beauty.calendar.service;

import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.*;
import org.springframework.stereotype.Service;

import ua.beauty.calendar.domain.CalendarEvent;
import ua.beauty.calendar.domain.dto.EventRequest;
import ua.beauty.calendar.utils.GoogleCalendarAPI;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


//это адаптер
@Service
public class CalendarServiceImpl implements CalendarService {

    private final GoogleCalendarAPI googleCalendarAPI = new GoogleCalendarAPI();




    @Override
    public CalendarEvent addEvents(EventRequest request) {

        String eventId = null;
        CalendarEvent calendarEvent = new CalendarEvent();
        calendarEvent.setSummary(request.getSummary());
        //use ISO8601DATEFORMAT

        Event event = new Event()
                .setSummary(calendarEvent.getSummary());




        DateTime startDateTime = new DateTime(request.getStartDateTime());

        EventDateTime start = new EventDateTime()
                .setDateTime(startDateTime);

        event.setStart(start);

        DateTime endDateTime = new DateTime(request.getEndDateTime());

        EventDateTime end = new EventDateTime()
                .setDateTime(endDateTime);
        event.setEnd(end);

        String calendarId = "primary";
        try {
            eventId = googleCalendarAPI.getEvents().insert(calendarId, event).execute().getId();
        } catch (IOException e) {
            e.printStackTrace();
        }
        calendarEvent.setEventId(eventId);
        return calendarEvent;
    }

    @Override
    public List<Event> getAllEvents()  {

        Events events = null;
        try {
            events = googleCalendarAPI.getEvents().list("primary")

                        .setTimeMin(new DateTime(System.currentTimeMillis()))
                        .setOrderBy("startTime")
                        .setSingleEvents(true)
                        .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return events.getItems();

    }




    @Override
    public List<CalendarEvent> getEventsByMaster(String master) {
        return null;
    }
}
