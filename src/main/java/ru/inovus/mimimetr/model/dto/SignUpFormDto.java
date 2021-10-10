package ru.inovus.mimimetr.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * Форма для регистрации
 */
@Schema(description = "Форма для регистрации")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpFormDto {

    /**
     * Юзернейм
     */
    @Schema(description = "Юзернейм")
    @NotEmpty(message = "{javax.validation.username.is.empty}")
    private String username;

    /**
     * Пароль
     */
    @Schema(description = "Пароль")
    @NotEmpty(message = "{javax.validation.password.is.empty}")
    private String password;
}
