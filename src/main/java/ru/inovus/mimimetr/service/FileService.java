package ru.inovus.mimimetr.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * Сервис для действий с файлами
 * */
public interface FileService {

    /**
     * Чтение файлов
     *
     * @param id идентификатор файла
     * */
    InputStream read(UUID id) throws IOException;
}