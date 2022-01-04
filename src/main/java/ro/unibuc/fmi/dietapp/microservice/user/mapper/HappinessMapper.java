package ro.unibuc.fmi.dietapp.microservice.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.unibuc.fmi.dietapp.microservice.user.dto.HappinessDto;
import ro.unibuc.fmi.dietapp.microservice.user.model.Happiness;

@Mapper(uses = {UserMapper.class})
public interface HappinessMapper extends EntityMapper<HappinessDto, Happiness> {
    @Mapping(target = "userDto", source = "user")
    HappinessDto toDto(Happiness happiness);

    @Mapping(target = "user", source = "userDto")
    Happiness toEntity(HappinessDto happinessDto);
}
