package ua.beauty.calendar.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long id;
    private Integer id;
    @NonNull
    private String name;
}
