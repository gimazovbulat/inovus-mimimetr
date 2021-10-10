package ru.inovus.mimimetr.model.mapper;

import org.mapstruct.Mapper;
import ru.inovus.mimimetr.model.dto.UserDto;
import ru.inovus.mimimetr.model.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromDto(UserDto userDto);

    UserDto toDto(User user);
}
