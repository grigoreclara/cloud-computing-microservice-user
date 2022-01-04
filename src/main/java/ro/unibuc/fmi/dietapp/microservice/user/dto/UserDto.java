package ro.unibuc.fmi.dietapp.microservice.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String last_name;
    private String first_name;
    private String username;
    private String gender;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birth_date;

    private CityDto cityDto;
}
