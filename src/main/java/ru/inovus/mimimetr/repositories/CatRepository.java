package ru.inovus.mimimetr.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.inovus.mimimetr.model.entity.Cat;

public interface CatRepository extends JpaRepository<Cat, Long> {

    Page<Cat> findAll(Pageable pageable);
}
