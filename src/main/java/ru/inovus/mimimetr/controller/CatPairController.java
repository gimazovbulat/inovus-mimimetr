package ru.inovus.mimimetr.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inovus.mimimetr.model.dto.CatPairDto;
import ru.inovus.mimimetr.security.CurrentUser;
import ru.inovus.mimimetr.service.CatPairService;
import ru.inovus.mimimetr.service.UsersService;

@RequestMapping("/api/v1/cats/pairs")
@RequiredArgsConstructor
@RestController
public class CatPairController {

    private final CatPairService catPairService;
    private final UsersService usersService;

    @Operation(description = "Получение пары котов")
    @GetMapping
    public Page<CatPairDto> get(
            @CurrentUser UserDetails userDetails,
            @PageableDefault Pageable pageable
    ) {
        String username = userDetails.getUsername();
        return catPairService.get(pageable, usersService.findByUsername(username));
    }
}
