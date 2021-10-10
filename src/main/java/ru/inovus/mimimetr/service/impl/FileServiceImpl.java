package ru.inovus.mimimetr.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import ru.inovus.mimimetr.exception.MimimetrException;
import ru.inovus.mimimetr.model.entity.FileDefinition;
import ru.inovus.mimimetr.repositories.FileDefinitionRepository;
import ru.inovus.mimimetr.service.FileService;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FileServiceImpl implements FileService {

    private final FileDefinitionRepository fileDefinitionRepository;

    @Value("${storage.dir}")
    private String storageDir;

    @Override
    public InputStream read(UUID id) throws IOException {
        FileDefinition fileDefinition = fileDefinitionRepository.findByPublicGuid(id)
                .orElseThrow(() -> {
                    throw new MimimetrException("file.not.found");
                });

        ClassPathResource classPathResource = new ClassPathResource(
                storageDir +
                        fileDefinition.getPublicGuid() + "." +
                        fileDefinition.getExtension()
        );
        return classPathResource.getInputStream();
    }
}
