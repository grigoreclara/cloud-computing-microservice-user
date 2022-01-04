package ro.unibuc.fmi.dietapp.microservice.user.mapper;

import org.mapstruct.Mapper;
import ro.unibuc.fmi.dietapp.microservice.user.dto.RegistrationDto;
import ro.unibuc.fmi.dietapp.microservice.user.model.Registration;

@Mapper
public interface RegistrationMapper extends EntityMapper<RegistrationDto, Registration> {
}
