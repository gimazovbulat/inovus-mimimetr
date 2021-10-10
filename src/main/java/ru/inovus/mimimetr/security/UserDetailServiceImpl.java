package ru.inovus.mimimetr.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.inovus.mimimetr.model.entity.User;
import ru.inovus.mimimetr.repositories.UsersRepository;
import ru.inovus.mimimetr.service.MessageService;

@RequiredArgsConstructor
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UsersRepository usersRepository;
    private final MessageService messageService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(messageService.get("user.not.found", username)));
        return new UserDetailsImpl(user.getUsername(), user.getPassword(), user.getRole());
    }
}
