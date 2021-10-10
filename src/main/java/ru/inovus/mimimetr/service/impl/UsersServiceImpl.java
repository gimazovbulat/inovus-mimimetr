package ru.inovus.mimimetr.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.inovus.mimimetr.model.dto.SignUpFormDto;
import ru.inovus.mimimetr.model.dto.UserDto;
import ru.inovus.mimimetr.model.entity.User;
import ru.inovus.mimimetr.model.enums.Role;
import ru.inovus.mimimetr.model.mapper.UserMapper;
import ru.inovus.mimimetr.repositories.UsersRepository;
import ru.inovus.mimimetr.service.MessageService;
import ru.inovus.mimimetr.service.UsersService;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final MessageService messageService;

    @Transactional
    @Override
    public UserDto save(SignUpFormDto signUpFormDto) {
        usersRepository
                .findByUsername(signUpFormDto.getUsername())
                .ifPresent((user) -> {
                    throw new BadCredentialsException(messageService.get("username.is.taken"));
                });

        User user = new User();
                user.setRole(Role.USER);
                user.setUsername(signUpFormDto.getUsername());
                user.setPassword(passwordEncoder.encode(signUpFormDto.getPassword()));

        log.info("Another like: {}", user);

        return userMapper.toDto(usersRepository.save(user));
    }

    @Override
    public UserDto findByUsername(String username) {
        User user = usersRepository
                .findByUsername(username)
                .orElseThrow(() -> {
                    throw new BadCredentialsException(messageService.get("user.not.found"));
                });
        return userMapper.toDto(user);
    }
}
