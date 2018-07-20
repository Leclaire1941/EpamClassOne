package com.epam.quadrangle.exceptions;

import com.epam.quadrangle.creator.QuadrangleCreator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class QuadrangleValidExceptionTest {
    private QuadrangleCreator quadrangleCreator = null;

    @BeforeClass
    public void beforeClass() {
        quadrangleCreator = new QuadrangleCreator();
    }

    @Test(expectedExceptions = QuadrangleValidException.class)
    public void shouldThrowQuadrangleValidException() throws QuadrangleValidException {
        Double[] incorrectCoordinates = new Double[]{150.0, 2.0, 150.0, 1.0, 150.0, 3.0, 1.0, 2.0, 3.0};
        quadrangleCreator.createQuadrangle(incorrectCoordinates);
    }

    @AfterClass
    public void afterClass(){
        quadrangleCreator = null;
    }

}