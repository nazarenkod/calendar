package ua.beauty.calendar.domain;



import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


//это Entity, но не персистентная
//может стать агрегатом если добавить мастера/клиента
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CalendarEvent {


    @NotNull
    @JsonProperty("eventId")
    private String eventId;

    @NotNull
    @JsonProperty("eventDateTime")
    private EventDateTime eventDateTime;

    @NotNull
    @JsonProperty("master")
    private String master;

    @NotNull
    @JsonProperty("summary")
    private String summary;

    @NotNull
    @JsonProperty("client")
    private Client client;

    @NotNull
    @JsonProperty("procedure")
    private String procedure;



}
