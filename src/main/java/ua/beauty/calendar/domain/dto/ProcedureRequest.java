package ua.beauty.calendar.domain.dto;

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
public class ProcedureRequest {

    @NonNull
    @NotBlank
    @JsonProperty("name")
    private String name;

}
