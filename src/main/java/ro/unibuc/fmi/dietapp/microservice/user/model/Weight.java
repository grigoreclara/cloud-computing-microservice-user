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
public class Weight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weight_id")
    private Long id;

    private Double weight_number;

    private LocalDateTime weight_date;

    @ManyToOne
    private User user;
}
