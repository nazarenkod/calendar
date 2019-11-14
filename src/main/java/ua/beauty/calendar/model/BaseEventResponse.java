package ua.beauty.calendar.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.api.services.calendar.model.Event;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseEventResponse {



    @NotNull
    @JsonProperty("status")
    private String status;

    @NotNull
    @JsonProperty("events")
    private List<Event> events;
}
