package ru.inovus.mimimetr.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inovus.mimimetr.model.dto.UserDto;
import ru.inovus.mimimetr.model.dto.UsersCatChoiceDto;
import ru.inovus.mimimetr.security.CurrentUser;
import ru.inovus.mimimetr.service.UsersCatChoiceService;
import ru.inovus.mimimetr.service.UsersService;
import ru.inovus.mimimetr.validation.ChoiceIsValid;

@RequestMapping("/api/v1/cats/chosen")
@RequiredArgsConstructor
@Validated
@RestController
public class UsersCatChoiceController {

    private final UsersCatChoiceService usersCatChoiceService;
    private final UsersService usersService;

    @Operation(description = "Выбор кота пользователем")
    @PostMapping
    public void saveUsersChoice(
            @CurrentUser UserDetails userDetails,
            @ChoiceIsValid
            @RequestBody
                    UsersCatChoiceDto choiceDto
    ) {
        UserDto user = usersService.findByUsername(userDetails.getUsername());
        usersCatChoiceService.saveUsersChoice(choiceDto, user);
    }
}
