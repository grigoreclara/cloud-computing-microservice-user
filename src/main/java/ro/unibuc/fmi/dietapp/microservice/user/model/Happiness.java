package ro.unibuc.fmi.dietapp.microservice.user.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Happiness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "happiness_id")
    private Long id;

    private Long happiness_level;

    private LocalDateTime happiness_date;

    @ManyToOne
    private User user;
}
