package ro.unibuc.fmi.dietapp.microservice.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.unibuc.fmi.dietapp.microservice.user.dto.HappinessDto;
import ro.unibuc.fmi.dietapp.microservice.user.dto.WeightDto;
import ro.unibuc.fmi.dietapp.microservice.user.model.Happiness;
import ro.unibuc.fmi.dietapp.microservice.user.model.User;
import ro.unibuc.fmi.dietapp.microservice.user.model.Weight;

@Mapper(uses = {UserMapper.class})
public interface WeightMapper extends EntityMapper<WeightDto, Weight>{
    @Mapping(target = "userDto", source = "user")
    WeightDto toDto(Weight weight);

    @Mapping(target = "user", source = "userDto")
    Weight toEntity(WeightDto weightDto);
}
