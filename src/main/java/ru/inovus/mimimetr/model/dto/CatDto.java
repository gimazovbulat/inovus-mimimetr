package ru.inovus.mimimetr.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

/**
 * Представление кота
 */
@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Представление кота")
public class CatDto {

    /**
     * Идентификатор кота
     */
    @Schema(description = "Идентификатор кота")
    @Id
    private Long id;

    /**
     * Имя кота
     */
    @Schema(description = "Имя кота")
    private String name;

    /**
     * Картинка
     * */
    @Schema(description = "Картинка")
    private FileDefinitionDto picture;

    /**
     * Лайки
     * */
    @Schema(description = "Лайки")
    private int likes;
}
