package ro.unibuc.fmi.dietapp.microservice.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HappinessDto {
    private Long id;
    private Long happiness_level;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime happiness_date;

    private UserDto userDto;
}
