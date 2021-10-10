package ru.inovus.mimimetr.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inovus.mimimetr.model.dto.SignUpFormDto;
import ru.inovus.mimimetr.model.dto.UserDto;
import ru.inovus.mimimetr.service.UsersService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UsersService usersService;

    @Operation(description = "Самая простая регистрация в мире :)")
    @PostMapping("/signUp")
    public UserDto signUp(@RequestBody @Valid SignUpFormDto signUpForm) {
        return usersService.save(signUpForm);
    }
}
