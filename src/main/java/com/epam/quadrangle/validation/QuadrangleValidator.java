package com.epam.quadrangle.validation;

import com.epam.quadrangle.entity.Point;
import com.epam.quadrangle.entity.Quadrangle;

public class QuadrangleValidator {

    public boolean isValidQuadrangle(Quadrangle quadrangle) {
        int numOfFalse = 0;
        Point quadranglePointA = quadrangle.getPointA();
        Point quadranglePointB = quadrangle.getPointB();
        Point quadranglePointC = quadrangle.getPointC();
        Point quadranglePointD = quadrangle.getPointD();
        
        boolean pointsABC = checkLineWithThreePoints(quadranglePointA, quadranglePointB, quadranglePointC);
        boolean pointsBCD = checkLineWithThreePoints(quadranglePointB, quadranglePointC, quadranglePointD);
        boolean pointsCDA = checkLineWithThreePoints(quadranglePointC, quadranglePointD, quadranglePointA);
        boolean pointsABD = checkLineWithThreePoints(quadranglePointA, quadranglePointB, quadranglePointD);

        if (!pointsABC) {
            numOfFalse += 1;
        } else if (!pointsABD) {
            numOfFalse += 1;
        } else if (!pointsBCD) {
            numOfFalse += 1;
        } else if (!pointsCDA) {
            numOfFalse += 1;
        }
        
        return numOfFalse == 0;
    }

    private boolean checkLineWithThreePoints(Point firstPoint, Point secondPoint, Point thirdPoint) {
        boolean firstPointXEqualSecondPointX = firstPoint.getX() == secondPoint.getX();
        boolean firstPointXEqualThirdPointX = firstPoint.getX() == thirdPoint.getX();
        boolean firstPointYEqualSecondPointY = firstPoint.getY() == secondPoint.getY();
        boolean firstPointYEqualThirdPointY = firstPoint.getY() == thirdPoint.getY();

        if ((firstPointXEqualSecondPointX && firstPointXEqualThirdPointX)
                || (firstPointYEqualSecondPointY && firstPointYEqualThirdPointY)) {
            return false;
        }

        return true;
    }
}
