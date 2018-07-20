package com.epam.quadrangle.creator;

import com.epam.quadrangle.action.Calculator;
import com.epam.quadrangle.entity.Point;
import com.epam.quadrangle.entity.Quadrangle;
import com.epam.quadrangle.entity.QuadrangleType;
import com.epam.quadrangle.exceptions.QuadrangleValidException;
import com.epam.quadrangle.validation.QuadrangleValidator;

public class QuadrangleCreator {
    private final QuadrangleValidator validator = new QuadrangleValidator();
    private final Calculator calculator = new Calculator();

    public Quadrangle createQuadrangle(Double[] coordinates) throws QuadrangleValidException {
        Point pointA = new Point(coordinates[0], coordinates[1]);
        Point pointB = new Point(coordinates[2], coordinates[3]);
        Point pointC = new Point(coordinates[4], coordinates[5]);
        Point pointD = new Point(coordinates[6], coordinates[7]);

        Quadrangle quadrangleToTest = new Quadrangle(pointA, pointB, pointC, pointD);

        if (!validator.isValidQuadrangle(quadrangleToTest)) {
            throw new QuadrangleValidException("Wasn't able to pass validation in isValidQuadrangle method");
        }

        QuadrangleType quadrangleType = calculator.defineTypeOfQuadrangle(quadrangleToTest);

        return new Quadrangle(pointA, pointB, pointC, pointD, quadrangleType);
    }
}

