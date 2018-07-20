package com.epam.quadrangle.creator;

import com.epam.quadrangle.entity.Point;
import com.epam.quadrangle.entity.Quadrangle;
import com.epam.quadrangle.exceptions.QuadrangleValidException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QuadrangleCreatorTest {

    private final QuadrangleCreator quadrangleCreator = new QuadrangleCreator();
    private final Point pointA = new Point(1.0, -3.6);
    private final Point pointB = new Point(2.4, 6.0);
    private final Point pointC = new Point(-1.5, 3.3);
    private final Point pointD = new Point(1.2, 4.0);
    private final Double[] inPutDoubles = new Double[]{1.0, -3.6, 2.4, 6.0, -1.5, 3.3, 1.2, 4.0};


    @Test
    public void shouldReturnQuadrangleWhenTakeDouble() throws QuadrangleValidException {
        Quadrangle expectedQuadrangle = new Quadrangle(pointA, pointB, pointC, pointD);
        Quadrangle actualQuadrangle = quadrangleCreator.createQuadrangle(inPutDoubles);

        Assert.assertEquals(expectedQuadrangle, actualQuadrangle);
    }
}