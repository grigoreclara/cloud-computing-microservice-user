package ro.unibuc.fmi.dietapp.microservice.user.model;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long id;

    @Column(name = "country_name")
    private String name;

    @Column(name = "country_code")
    private String code;

    @OneToMany(mappedBy = "country", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<City> cityList;

}
