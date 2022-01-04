package ro.unibuc.fmi.dietapp.microservice.user.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CityDto {
    private Long id;
    private String name;
    private CountryDto countryDto;
}
