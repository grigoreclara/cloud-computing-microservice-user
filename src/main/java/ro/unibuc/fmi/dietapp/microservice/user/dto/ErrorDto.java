package ro.unibuc.fmi.dietapp.microservice.user.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {
    private Integer code;
    private String message;
}
