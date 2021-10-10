package ru.inovus.mimimetr.model.entity;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;

/**
 * Котик
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@Getter
@Setter
@Table
public class Cat {

    /**
     * Идентификатор кота
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cat_seq_gen")
    @SequenceGenerator(
            name = "cat_seq_gen",
            sequenceName = "cat_seq",
            allocationSize = 1)
    private Long id;

    /**
     * Имя кота
     */
    private String name;

    private int likes;

    /**
     * Фотография кота
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "picture_id")
    private FileDefinition picture;
}
