package ua.beauty.calendar.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateEventResponse {
    @JsonProperty("id")
    private long id;
    @JsonProperty("status")
    private String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("message")
    private String message;


    public CreateEventResponse(String status, String message, Long id) {
        this.status = status;
        this.message = message;
        this.id = id;
    }
}
