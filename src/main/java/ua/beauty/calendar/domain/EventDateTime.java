package ua.beauty.calendar.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EventDateTime {


    @NotNull
    private String date;

    @NotNull
    @JsonProperty("startTime")
    private String startTime;

    @NotNull
    @JsonProperty("endTime")
    private String endTime;
}
