package ua.beauty.calendar.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import ua.beauty.calendar.domain.Master;

import java.util.List;

public class MasterResponse {

    @JsonProperty("status")
    private String status;
    @JsonProperty("masters")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Master> masters;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("message")
    private String message;


    public MasterResponse(String status, List<Master> masters) {
        this.status = status;
        this.masters = masters;
    }

    public MasterResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
