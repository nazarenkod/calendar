package ua.beauty.calendar.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter @Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull

    private String clientName;
    @NotNull

    private String phoneNumber;
    @NotNull

    private String instagram;
    @NotNull

    private String price;
    @NotNull

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

    @ManyToOne
    @JoinColumn
    @NotNull
    private Master master;

    @ManyToOne
    @JoinColumn
    @NotNull
    private Procedure procedure;

}

