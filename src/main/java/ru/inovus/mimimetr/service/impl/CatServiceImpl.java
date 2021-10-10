package ru.inovus.mimimetr.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.inovus.mimimetr.exception.MimimetrException;
import ru.inovus.mimimetr.model.dto.CatDto;
import ru.inovus.mimimetr.model.entity.Cat;
import ru.inovus.mimimetr.model.mapper.CatMapper;
import ru.inovus.mimimetr.repositories.CatRepository;
import ru.inovus.mimimetr.service.CatService;
import ru.inovus.mimimetr.service.MessageService;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;
    private final CatMapper catMapper;
    private final MessageService messageService;

    @Override
    public CatDto get(Long id) {
        return catMapper.toDto(findById(id));
    }

    @Transactional
    @Override
    public void update(CatDto dto) {
        Cat byId = findById(dto.getId());
        catMapper.merge(dto, byId);
    }

    @Override
    public Page<CatDto> getTop10() {
        PageRequest pageReq = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, Cat.Fields.likes));
        return catRepository.findAll(pageReq).map(catMapper::toDto);
    }

    private Cat findById(Long id) {
        return catRepository
                .findById(id)
                .orElseThrow(() -> new MimimetrException(messageService.get("cat.not.found", id)));
    }
}
