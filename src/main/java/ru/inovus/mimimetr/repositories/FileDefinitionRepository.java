package ru.inovus.mimimetr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inovus.mimimetr.model.entity.FileDefinition;

import java.util.Optional;
import java.util.UUID;

public interface FileDefinitionRepository extends JpaRepository<FileDefinition, Long> {

    Optional<FileDefinition> findByPublicGuid(UUID id);
}
