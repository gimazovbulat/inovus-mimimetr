package ru.inovus.mimimetr.service;

import ru.inovus.mimimetr.model.dto.UserDto;
import ru.inovus.mimimetr.model.dto.UsersCatChoiceDto;

public interface UsersCatChoiceService {

    /**
     * сохранить выбор пользователя
     * */
    void saveUsersChoice(UsersCatChoiceDto dto, UserDto user);
}
