package ru.inovus.mimimetr.model.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Выбор кота пользователем
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users_cat_choice")
@Entity
public class UsersCatChoice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_cat_choice_seq_gen")
    @SequenceGenerator(
            name = "users_cat_choice_seq_gen",
            sequenceName = "users_cat_choice_seq",
            allocationSize = 1)
    private Long id;

    /**
     * Пользователь, выбравший кота
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    /**
     * Кот 1
     */
    @JoinColumn(name = "cat1_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cat cat1;

    /**
     * Кот 2
     */
    @JoinColumn(name = "cat2_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cat cat2;

    /**
     * Выбранный кот
     */
    @JoinColumn(name = "chosen_cat_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Cat chosenCat;
}
