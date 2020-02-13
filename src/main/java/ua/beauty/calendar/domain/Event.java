package ua.beauty.calendar.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter @Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull

    private String clientName;
    @NonNull

    private String phoneNumber;
    @NonNull

    private String instagram;
    @NonNull

    private String price;
    @NonNull

    private String startDateTime;
    @NonNull

    private String endDateTime;

}

