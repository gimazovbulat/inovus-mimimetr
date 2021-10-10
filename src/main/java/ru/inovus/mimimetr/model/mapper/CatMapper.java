package ru.inovus.mimimetr.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.inovus.mimimetr.model.dto.CatDto;
import ru.inovus.mimimetr.model.entity.Cat;

@Mapper(componentModel = "spring", uses = FileDefinitionMapper.class)
public interface CatMapper {

    Cat fromDto(CatDto dto);

    CatDto toDto(Cat cat);

    void merge(CatDto source, @MappingTarget Cat target);
}
