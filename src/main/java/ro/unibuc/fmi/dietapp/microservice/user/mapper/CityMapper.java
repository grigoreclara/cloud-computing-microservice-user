package ro.unibuc.fmi.dietapp.microservice.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.unibuc.fmi.dietapp.microservice.user.dto.CityDto;
import ro.unibuc.fmi.dietapp.microservice.user.model.City;

@Mapper(uses = {CountryMapper.class})
public interface CityMapper extends EntityMapper<CityDto, City>{
    @Mapping(target = "countryDto", source = "country")
    CityDto toDto(City city);

    @Mapping(target = "country", source = "countryDto")
    City toEntity(CityDto cityDto);
}
