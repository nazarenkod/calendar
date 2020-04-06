package ua.beauty.calendar.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import ua.beauty.calendar.domain.Procedure;

import java.util.List;

public class ProcedureResponse {

    @JsonProperty("status")
    private String status;
    @JsonProperty("procudures")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Procedure> procudures;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("message")
    private String message;


    public ProcedureResponse(String status, List<Procedure> procudures) {
        this.status = status;
        this.procudures = procudures;
    }

    public ProcedureResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
