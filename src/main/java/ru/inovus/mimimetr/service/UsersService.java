package ru.inovus.mimimetr.service;

import ru.inovus.mimimetr.model.dto.SignUpFormDto;
import ru.inovus.mimimetr.model.dto.UserDto;

/**
 * Сервис для действий с пользователем
 * */
public interface UsersService {

    /**
     * Регистрация пользователя
     * @param signUpFormDto форма регистрации
     * @return пользователь
     * */
    UserDto save(SignUpFormDto signUpFormDto);

    /**
     * Найти польхователя по юзернейму
     *
     * @param username юзернейм пользователя
     *
     * @return пользователь
     * */
    UserDto findByUsername(String username);
}
