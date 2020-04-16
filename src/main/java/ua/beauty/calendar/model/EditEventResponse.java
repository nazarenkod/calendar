package ua.beauty.calendar.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EditEventResponse {

    @JsonProperty("status")
    private String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("message")
    private String message;
    //   @JsonProperty("id")
//    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
//    private long id;


    public EditEventResponse(String status, String message, Long id) {
        this.status = status;
        this.message = message;
        //   this.id = id;
    }

    public EditEventResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
