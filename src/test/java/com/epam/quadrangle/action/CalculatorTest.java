package com.epam.quadrangle.action;

import com.epam.quadrangle.entity.Point;
import com.epam.quadrangle.entity.Quadrangle;
import com.epam.quadrangle.entity.QuadrangleType;
import com.epam.quadrangle.entity.Vector;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();
    private final Point testPointA = new Point(1.0, -3.6);
    private final Point testPointB = new Point(2.4, 6.0);
    private final Point testPointC = new Point(-1.5, 3.3);
    private final Point testPointD = new Point(1.2, 4.0);
    private final Quadrangle testQuadrangle =
            new Quadrangle(testPointA, testPointB, testPointC, testPointD, QuadrangleType.SQUARE);
    private final Vector testVectorAB = new Vector(testPointA, testPointB);
    private final Vector testVectorBC = new Vector(testPointB, testPointC);
    private final Vector testVectorCD = new Vector(testPointC, testPointD);
    private final Vector testVectorDA = new Vector(testPointD, testPointA);


    @Test
    public void shouldReturnQuadrangleTypeWhenDefineTypeOfQuadrangle() {
        QuadrangleType expectedType = QuadrangleType.SQUARE;
        QuadrangleType actualType = testQuadrangle.getTypeOfQuadrangle();

        Assert.assertEquals(expectedType, actualType);
    }

    @Test
    public void shouldReturnFalseWhenVectorsAreNotPerpendicular() {
        boolean actualResult = calculator.areVectorsPerpendicular(testVectorAB, testVectorBC);

        Assert.assertFalse(actualResult);
    }

    @Test
    public void shouldReturnTrueWhenVectorsArePerpendicular() {
        Point pointA = new Point(2.0, 2.0);
        Point pointB = new Point(4.0, 2.0);
        Point pointC = new Point(4.0, 4.0);
        Vector vectorAB = new Vector(pointA, pointB);
        Vector vectorBC = new Vector(pointB, pointC);

        boolean actualResult = calculator.areVectorsPerpendicular(vectorAB, vectorBC);

        Assert.assertTrue(actualResult);
    }

    @Test
    public void shouldReturnFalseWhenVectorsAreNotParallel() {
        boolean actualResult = calculator.areVectorsParallel(testVectorAB, testVectorCD);
        Assert.assertFalse(actualResult);

    }

    @Test
    public void shouldReturnDoubleWhenCalculateQuadranglePerimeter() {
        double expectedAmount = 24.836859018456046;
        double actualAmount = calculator.calculateQuadranglePerimeter(testQuadrangle);

        Assert.assertEquals(expectedAmount, actualAmount);
    }

    @Test
    public void shouldReturnDoubleSquareWhenCalculateQuadrangleSquare() {
        double expectedAmount = 31.095926162800335;
        double actualAmount = calculator.calculateQuadrangleSquare(testQuadrangle);

        Assert.assertEquals(expectedAmount, actualAmount);
    }

    @Test
    public void shouldReturnNegativeFourNinePointThreeTwoWhenCalculateVectorScalarMultiplication() {
        double expectedAmount = -49.32;
        double actualAmount = calculator.calculateVectorScalarMultiplication(testVectorAB, testVectorBC);

        Assert.assertEquals(expectedAmount, actualAmount);
    }

    @Test
    public void shouldReturnDoubleVectorLength() {
        double expectedLength = 7.602631123499285;
        double actualLength = calculator.calculateVectorLength(testVectorDA);

        Assert.assertEquals(expectedLength, actualLength);
    }
}