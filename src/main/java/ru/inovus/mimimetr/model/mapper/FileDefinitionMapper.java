package ru.inovus.mimimetr.model.mapper;

import org.mapstruct.Mapper;
import ru.inovus.mimimetr.model.dto.FileDefinitionDto;
import ru.inovus.mimimetr.model.entity.FileDefinition;

@Mapper(componentModel = "spring")
public interface FileDefinitionMapper {

    FileDefinition fromDto(FileDefinitionDto dto);

    FileDefinitionDto toDto(FileDefinition definition);
}
