package ru.inovus.mimimetr.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inovus.mimimetr.model.dto.CatDto;
import ru.inovus.mimimetr.service.CatService;

@RequestMapping("/api/v1/cats")
@RestController
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;

    @GetMapping("/top")
    @Operation(description = "Получение топ 10 котов")
    public Page<CatDto> getTop(){
        return catService.getTop10();
    }
}
