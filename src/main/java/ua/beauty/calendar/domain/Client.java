package ua.beauty.calendar.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Client {

    @NotNull
    @JsonProperty("phone")
    private String phone;

    @NotNull
    @JsonProperty("instagram")
    private String instagram;


}
