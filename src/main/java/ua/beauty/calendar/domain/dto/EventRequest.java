package ua.beauty.calendar.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;

//Это DataTransferObject
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class EventRequest {




    @NonNull
    @NotBlank
    @JsonProperty("endDateTime")
    private String endDateTime;

    @NonNull
    @NotBlank
    @JsonProperty("startDateTime")
    private String startDateTime;


    //сдулать проверку на наличие из Dictionary
    @NonNull
    @JsonProperty("master")
    private String master;

    @NonNull
    @NotBlank
    @JsonProperty("summary")
    private String summary;
}
