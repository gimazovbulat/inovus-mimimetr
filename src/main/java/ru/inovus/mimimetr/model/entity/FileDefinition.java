package ru.inovus.mimimetr.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

/**
 * Представление файла
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "file_definition")
public class FileDefinition {

    /**
     * Идентфикатор для файла
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "file_definition_seq_gen")
    @SequenceGenerator(
            name = "file_definition_seq_gen",
            sequenceName = "file_definition_seq",
            allocationSize = 1)
    private Long id;

    /**
     * Оригинальное имя
     */
    @Column(name = "original_name", nullable = false)
    private String originalName;

    /**
     * Гуид
     */
    @Column(name = "public_guid", nullable = false)
    private UUID publicGuid;

    /**
     * Расширение файла
     */
    @Column(name = "extension", nullable = false)
    private String extension;
}
