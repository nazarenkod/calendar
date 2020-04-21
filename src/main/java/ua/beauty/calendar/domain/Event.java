package ua.beauty.calendar.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

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


    private String clientName;

    private String phoneNumber;

    private String instagram;

    private String price;

    //@JsonProperty("date")
    @NonNull
    private String date;


    @JsonProperty("time")
    private String time;

    // @JsonProperty("duration")
    private String duration;

    @ManyToOne
    @JoinColumn
    @NonNull
    private Master master;

    @ManyToOne
    @JoinColumn
    private Procedure procedure;

    private String additionalInfo;
    @NonNull
    private Boolean freeDay;

}

