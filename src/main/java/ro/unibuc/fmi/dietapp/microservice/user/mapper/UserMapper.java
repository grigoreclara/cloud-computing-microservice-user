package ro.unibuc.fmi.dietapp.microservice.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.unibuc.fmi.dietapp.microservice.user.dto.UserDto;
import ro.unibuc.fmi.dietapp.microservice.user.model.User;

@Mapper(uses = {CityMapper.class})
public interface UserMapper extends EntityMapper<UserDto, User> {
    @Mapping(target = "cityDto", source = "city")
    UserDto toDto(User user);

    @Mapping(target = "city", source = "cityDto")
    User toEntity(UserDto userDto);
}
