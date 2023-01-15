package ru.vitasoft.ru.vitasoft.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.vitasoft.ru.vitasoft.dto.UserDto;
import ru.vitasoft.ru.vitasoft.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto convertToUserFromUserDto(User user);

    User convertToUserDtoFromUser(UserDto userDto);

    void updateFromDto(UserDto userDto, @MappingTarget User user);
}
