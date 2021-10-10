package ru.inovus.mimimetr.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.inovus.mimimetr.model.dto.CatPairDto;
import ru.inovus.mimimetr.model.dto.UserDto;

public interface CatPairService {

    /**
     * Получение пар котов
     *
     * @param user - для кого искать пары
     * @return Пары котов
     * */
    Page<CatPairDto> get(Pageable pageable, UserDto user);
}
