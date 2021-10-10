package ru.inovus.mimimetr.service;

import org.springframework.data.domain.Page;
import ru.inovus.mimimetr.model.dto.CatDto;

/**
 * Сервис для действий с котами
 * */
public interface CatService {

    /**
     * Получить кота по идентификатору
     *
     * @param id идентификатор кота
     * @return кот
     * */
    CatDto get(Long id);

    /**
     * Обновить кота
     *
     * @param dto обновление кота
     * */
    void update(CatDto dto);

    /**
     * Получить топ котов
     *
     * @return топ котов
     * */

    Page<CatDto> getTop10();
}
