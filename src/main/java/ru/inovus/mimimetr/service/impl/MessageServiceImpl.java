package ru.inovus.mimimetr.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;
import ru.inovus.mimimetr.service.MessageService;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageSourceAccessor accessor;

    @Override
    public String get(String code, Object... args) {
        return accessor.getMessage(code, args);
    }
}
