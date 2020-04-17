package ua.beauty.calendar.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RemoveEventResponse {

    @JsonProperty("status")
    private String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("message")
    private String message;


    public RemoveEventResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
