package ru.inovus.mimimetr.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.inovus.mimimetr.exception.MimimetrException;
import ru.inovus.mimimetr.model.dto.CatPair;
import ru.inovus.mimimetr.model.dto.CatPairDto;
import ru.inovus.mimimetr.model.dto.UserDto;
import ru.inovus.mimimetr.model.entity.Cat;
import ru.inovus.mimimetr.model.mapper.CatMapper;
import ru.inovus.mimimetr.repositories.CatRepository;
import ru.inovus.mimimetr.repositories.FileDefinitionRepository;
import ru.inovus.mimimetr.service.CatPairService;
import ru.inovus.mimimetr.service.MessageService;

import java.sql.ResultSet;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CatPairServiceImpl implements CatPairService {

    private final CatRepository catRepository;
    private final JdbcTemplate jdbcTemplate;
    private final CatMapper catMapper;
    private final MessageService messageService;

    RowMapper<CatPair> catPairRowMapper = (ResultSet rs, int rowNum) -> {
        long cat1 = rs.getLong("cat1_id");
        long cat2 = rs.getLong("cat2_id");

        return new CatPair(cat1, cat2);
    };

    @Override
    public Page<CatPairDto> get(Pageable pageable, UserDto user) {
        String query =
                "SELECT cat1.id cat1_id, cat2.id cat2_id " +
                        "FROM cat cat1" +
                        " CROSS JOIN " +
                        "cat cat2 " +
                        "WHERE cat1.id < cat2.id " +
                        "EXCEPT " +
                        "SELECT cat1_id, cat2_id FROM users_cat_choice WHERE user_id = ? LIMIT ? OFFSET ?";

        List<CatPair> catPairs = jdbcTemplate.query(
                query,
                catPairRowMapper,
                user.getId(),
                pageable.getPageSize(),
                pageable.getOffset()
        );

        List<CatPairDto> unseenCats = catPairs.stream().map(
                catPair -> {
                    Cat cat1 = findById(catPair.getCat1Id());
                    Cat cat2 = findById(catPair.getCat2Id());
                    return new CatPairDto(catMapper.toDto(cat1), catMapper.toDto(cat2));
                }
        ).collect(Collectors.toList());

        Collections.shuffle(unseenCats);

        log.info("Found cat pairs: {}", unseenCats);

        return new PageImpl<>(unseenCats, pageable, unseenCats.size());
    }

    private Cat findById(Long id) {
        return catRepository
                .findById(id)
                .orElseThrow(() -> new MimimetrException(messageService.get("cat.not.found", id)));
    }
}
