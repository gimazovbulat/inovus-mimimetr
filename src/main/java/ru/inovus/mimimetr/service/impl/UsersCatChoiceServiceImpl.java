package ru.inovus.mimimetr.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.inovus.mimimetr.model.dto.CatDto;
import ru.inovus.mimimetr.model.dto.UserDto;
import ru.inovus.mimimetr.model.dto.UsersCatChoiceDto;
import ru.inovus.mimimetr.model.entity.UsersCatChoice;
import ru.inovus.mimimetr.model.mapper.CatMapper;
import ru.inovus.mimimetr.model.mapper.UserMapper;
import ru.inovus.mimimetr.repositories.UsersCatChoiceRepository;
import ru.inovus.mimimetr.service.CatService;
import ru.inovus.mimimetr.service.UsersCatChoiceService;

@RequiredArgsConstructor
@Service
@Slf4j
public class UsersCatChoiceServiceImpl implements UsersCatChoiceService {

    private final UsersCatChoiceRepository usersCatChoiceRepository;
    private final CatService catService;
    private final UserMapper userMapper;
    private final CatMapper catMapper;

    @Transactional
    @Override
    public void saveUsersChoice(UsersCatChoiceDto dto, UserDto userDto) {
        CatDto cat1 = catService.get(dto.getPair().getCat1Id());
        CatDto cat2 = catService.get(dto.getPair().getCat2Id());
        CatDto chosenCat = dto.getChosenCatId().equals(cat1.getId()) ? cat1 : cat2;

        UsersCatChoice choice = UsersCatChoice.builder()
                .cat1(catMapper.fromDto(cat1))
                .cat2(catMapper.fromDto(cat2))
                .chosenCat(catMapper.fromDto(chosenCat))
                .user(userMapper.fromDto(userDto))
                .build();

        usersCatChoiceRepository.save(choice);
        chosenCat.setLikes(chosenCat.getLikes() + 1);
        catService.update(chosenCat);
        log.info("Cat got another like: {}", chosenCat);
    }
}
