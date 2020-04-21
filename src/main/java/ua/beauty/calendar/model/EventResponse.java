package ua.beauty.calendar.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import ua.beauty.calendar.domain.Event;

import java.util.List;

public class EventResponse {

    @JsonProperty("status")
    private String status;
    @JsonProperty("events")
    // @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Event> events;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("message")
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
