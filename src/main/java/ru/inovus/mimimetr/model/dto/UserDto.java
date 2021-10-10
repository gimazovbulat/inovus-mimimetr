package ru.inovus.mimimetr.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import ru.inovus.mimimetr.model.enums.Role;

import java.util.Objects;

/**
 * Представление пользователя
 * */
@Schema(description = "Представление пользователя")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    /**
     * Идентификатор пользователя
     * */
    @Schema(description = "Идентификатор пользователя")
    private Long id;

    /**
     * Юзернейм пользователя
     * */
    @Schema(description = "Юзернейм пользователя")
    private String username;

    /**
     * Пароль пользователя
     * */
    @Schema(description = "Пароль пользователя")
    private String password;

    /**
     * Роль пользователя
     * */
    @Schema(description = "Роль пользователя")
    private Role role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return getUsername().equals(userDto.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername());
    }
}
