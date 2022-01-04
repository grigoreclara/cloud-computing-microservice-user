package ro.unibuc.fmi.dietapp.microservice.user.model;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "LAST_NAME")
    private String last_name;
    @Column(name = "FIRST_NAME")
    private String first_name;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "BIRTH_DATE")
    private LocalDate birth_date;
    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Happiness> happinessList;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Weight> weightList;

    @OneToOne
    private Account account;
}
