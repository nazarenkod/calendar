package ua.beauty.calendar.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

//Это DataTransferObject
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class EventRequest {

    @NonNull
    @NotBlank
    @JsonProperty("clientName")
    private String clientName;

    @NonNull
    @NotBlank
    @JsonProperty("phoneNumber")
    private String phoneNumber;


    //сдулать проверку на наличие из Dictionary
    @NonNull
    @JsonProperty("instagram")
    private String instagram;

    @NonNull
    @NotBlank
    @JsonProperty("price")
    private String price;

    @NonNull
    @NotBlank
    @JsonProperty("date")
    private String date;

    @NonNull
    @NotBlank
    @JsonProperty("time")
    private String time;

    @NonNull
    @NotBlank
    @JsonProperty("duration")
    private String duration;

    @NonNull
    @JsonProperty("master")
    private Master master;

    @NonNull
    @JsonProperty("procedure")
    private Procedure procedure;
}
