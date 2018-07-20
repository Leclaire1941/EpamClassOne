package com.epam.quadrangle.validation;

import com.epam.quadrangle.entity.Quadrangle;
import com.epam.quadrangle.exceptions.QuadrangleValidException;
import com.epam.quadrangle.creator.QuadrangleCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QuadrangleValidatorTest {
    private static final Double[] CORRECT_DOUBLES = new Double[]{1.0, -3.6, 2.4, 6.0, -1.5, 3.3, 1.2, 4.0};
    private static final Double[] FALSE_DOUBLES = new Double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
    private final QuadrangleCreator quadrangleCreator = new QuadrangleCreator();
    private final QuadrangleValidator quadrangleValidator = new QuadrangleValidator();


    @Test
    public void shouldReturnTrueWhenIsValidQuadrangle() throws QuadrangleValidException {
        Quadrangle quadrangle = quadrangleCreator.createQuadrangle(CORRECT_DOUBLES);
        boolean result = quadrangleValidator.isValidQuadrangle(quadrangle);

        Assert.assertTrue(result);
    }

    @Test(expectedExceptions = QuadrangleValidException.class)
    public void shouldReturnFalseWhenIsValidQuadrangle() throws QuadrangleValidException {
        Quadrangle quadrangle = quadrangleCreator.createQuadrangle(FALSE_DOUBLES);

    }
}