package ru.inovus.mimimetr.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.inovus.mimimetr.model.entity.UsersCatChoice;

import java.util.List;

public interface UsersCatChoiceRepository extends JpaRepository<UsersCatChoice, Long> {

     List<UsersCatChoice> findAllByUser_Id(Long id);
}
