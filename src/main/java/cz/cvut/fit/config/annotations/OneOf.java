package cz.cvut.fit.config.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import cz.cvut.fit.config.OneOfValidator;

/**
 * A property constraint restricting the property content only to certain
 * values.
 *
 * @author ytoh
 */
@Constraint(validatedBy = OneOfValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface OneOf {

    /**
     * Values to choose from.
     *
     * @return an array of possible options
     */
    String[] value();

    String message() default "Only one of options {value}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
