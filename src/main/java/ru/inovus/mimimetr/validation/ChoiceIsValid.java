package ru.inovus.mimimetr.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = ChoiceIsValidConstraint.class)
@Documented
public @interface ChoiceIsValid {

    String message() default "{javax.validation.chosen.cat.not.in.pair}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
