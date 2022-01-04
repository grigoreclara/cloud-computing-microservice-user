package ro.unibuc.fmi.dietapp.microservice.user.mapper;

import org.mapstruct.Mapper;
import ro.unibuc.fmi.dietapp.microservice.user.dto.CountryDto;
import ro.unibuc.fmi.dietapp.microservice.user.model.Country;

@Mapper
public interface CountryMapper extends EntityMapper<CountryDto, Country> {
}
