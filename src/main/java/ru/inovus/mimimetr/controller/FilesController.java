package ru.inovus.mimimetr.controller;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inovus.mimimetr.service.FileService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/files")
public class FilesController {

    private final FileService fileService;

    @PreAuthorize("permitAll()")
    @GetMapping("/{uuid}")
    public void read(
            @Parameter(description = "Идентификатор картинки", required = true)
            @PathVariable("uuid") UUID id,
            HttpServletResponse response
    ) {
        try (InputStream inputStream = fileService.read(id)) {
            response.setContentType(IMAGE_JPEG_VALUE);
            FileCopyUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            log.error("Cannot get file {}", e.getMessage());
        }
    }
}
