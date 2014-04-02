package cz.cvut.fit.alg.params;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import cz.cvut.fit.alg.params.annotations.Range;

/**
 * A {@link ConstraintValidator} instance validating numbers for a certain
 * range.
 *
 * @author ytoh
 */
public class InRangeValidator implements ConstraintValidator<Range, Number> {

    private double low = Double.MIN_VALUE;
    private double high = Double.MAX_VALUE;

    @Override
    public void initialize(Range annotation) {
        if (annotation.from() >= annotation.to()) {
            throw new ConfigException(
                    "Invalid range (" + annotation.from() + " -> " + annotation.to()
                    + "). Property cannot be set.");
        }

        low = annotation.from();
        high = annotation.to();
    }

    @Override
    public boolean isValid(Number input, ConstraintValidatorContext constraintValidatorContext) {
        if (input == null) {
            return true;
        }

        return input.doubleValue() >= low && input.doubleValue() <= high;
    }
}
