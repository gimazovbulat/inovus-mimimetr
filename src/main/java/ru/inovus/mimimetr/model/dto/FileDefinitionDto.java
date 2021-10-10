package ru.inovus.mimimetr.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Представление файла
 * */
@Schema(description = "Представление файла")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDefinitionDto {

    private Long id;

    /**
     * Оригинальное имя
     */
    @Schema(description = "Оригинальное имя")
    private String originalName;

    /**
     * Гуид
     */
    @Schema(description = "Гуид")
    private UUID publicGuid;

    /**
     * Расширение файла
     */
    @Schema(description = "Расширение файла")
    private String extension;
}
