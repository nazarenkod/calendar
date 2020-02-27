package ua.beauty.calendar.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    @NotNull

    private String phoneNumber;
    @NotNull

    private String instagram;
    @NotNull

    private String price;
    @NotNull

    private String startDateTime;
    @NotNull

    private String endDateTime;
    @ManyToOne
    @JoinColumn
    @NotNull
    private Master master;

}

