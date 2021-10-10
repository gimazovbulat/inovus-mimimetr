package ru.inovus.mimimetr.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Пара котов
 */
@Schema(description = "Пара котов")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatPairDto {

    /**
     * 1 кот
     */
    @Schema(description = "1 кот")
    private CatDto cat1;


    /**
     * 2 кот
     */
    @Schema(description = "2 кот")
    private CatDto cat2;
}
