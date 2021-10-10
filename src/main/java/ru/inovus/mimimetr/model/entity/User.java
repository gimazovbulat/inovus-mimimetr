package ru.inovus.mimimetr.model.entity;

import lombok.*;
import ru.inovus.mimimetr.model.enums.Role;

import javax.persistence.*;
import java.util.List;

/**
 * Пользователь
 * */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table
@Setter
@Entity
public class User {

    /**
     * Идентификатор пользователя
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
    @SequenceGenerator(
            name = "user_seq_gen",
            sequenceName = "user_seq",
            allocationSize = 1)
    private Long id;

    /**
     * Юзернейм пользователя
     * */
    private String username;

    /**
     * Пароль пользователя
     * */
    private String password;

    /**
     * Роль пользователя
     * */
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "user")
    private List<UsersCatChoice> seenCats;
}
