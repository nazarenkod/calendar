package ua.beauty.calendar.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Master {

    @NotNull
    @JsonProperty("id")
    private long id;

    @NotNull
    @JsonProperty("name")
    private String name;


}
