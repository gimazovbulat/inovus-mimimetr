package ru.inovus.mimimetr.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Пара котов
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatPair {

    /**
     * Идентификатор 1 кота
     */
    @NotNull
    private Long cat1Id;

    /**
     * Идентификатор 2 кота
     */
    @NotNull
    private Long cat2Id;
}
