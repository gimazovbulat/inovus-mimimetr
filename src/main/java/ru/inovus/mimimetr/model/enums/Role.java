package ru.inovus.mimimetr.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

/**
 * Роль пользователя
 * */
@AllArgsConstructor
@Getter
public enum Role implements GrantedAuthority {

    USER("USER");

    private final String val;

    @Override
    public String getAuthority() {
        return getVal();
    }
}
