package ru.inovus.mimimetr.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Выбор кота пользователем
 */
@Schema(description = "Выбор кота пользователем")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersCatChoiceDto {

    /**
     * Пара котов
     * */
    @Schema(description = "Пара котов")
    @Valid
    private CatPair pair;

    /**
     * Выбранный кот
     */
    @Schema(description = "Выбранный кот")
    @NotNull
    private Long chosenCatId;

    /**
     * Пользователь
     */
    @Schema(description = "Пользователь")
    private UserDto user;
}
