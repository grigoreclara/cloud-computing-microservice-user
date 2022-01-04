package ro.unibuc.fmi.dietapp.microservice.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeightDto {
    private Long id;
    private Double weight_number;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime weight_date;

    private UserDto userDto;
}
