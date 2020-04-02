package ua.beauty.calendar.model;

import ua.beauty.calendar.domain.Event;

import java.util.List;

public class EventResponse {


    private String status;
    private List<Event> events;
    private String message;


    public EventResponse(String status, List<Event> events) {
        this.status = status;
        this.events = events;
    }

    public EventResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
