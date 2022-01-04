package ro.unibuc.fmi.dietapp.microservice.user.model;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acccount_id")
    private Long id;

    private String password;

    private String role;

    @Column(columnDefinition = "varchar(1)")
    private String active;

    @OneToOne
    private User user;
}
