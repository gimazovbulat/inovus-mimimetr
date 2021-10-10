package ru.inovus.mimimetr.validation;

import ru.inovus.mimimetr.model.dto.UsersCatChoiceDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ChoiceIsValidConstraint implements ConstraintValidator<ChoiceIsValid, UsersCatChoiceDto> {

    @Override
    public boolean isValid(UsersCatChoiceDto choiceDto, ConstraintValidatorContext ctx) {
        Long cat1Id = choiceDto.getPair().getCat1Id();
        Long cat2Id = choiceDto.getPair().getCat2Id();
        Long chosenCatId = choiceDto.getChosenCatId();

        return chosenCatId.equals(cat1Id) || chosenCatId.equals(cat2Id);
    }
}
