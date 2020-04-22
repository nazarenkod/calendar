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
public class EditEventRequest {

    @NonNull
    @NotBlank
    @JsonProperty("id")
    private Long id;


    @JsonProperty("clientName")
    private String clientName;

    @JsonProperty("phoneNumber")
    private String phoneNumber;


    //сдулать проверку на наличие из Dictionary

    @JsonProperty("instagram")
    private String instagram;


    @JsonProperty("price")
    private String price;

    @NonNull
    @NotBlank
    @JsonProperty("date")
    private String date;

    @JsonProperty("time")
    private String time;


    @JsonProperty("duration")
    private String duration;

    @NonNull
    @NotBlank
    @JsonProperty("master")
    private Master master;

    @JsonProperty("procedure")
    private Procedure procedure;

    @JsonProperty("additionalInfo")
    private String additionalInfo;

    @JsonProperty("freeDay")
    private Boolean freeDay;
}
