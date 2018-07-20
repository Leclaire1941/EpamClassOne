package com.epam.quadrangle.action;

import com.epam.quadrangle.entity.Point;
import com.epam.quadrangle.entity.Quadrangle;
import com.epam.quadrangle.entity.QuadrangleType;
import com.epam.quadrangle.entity.Vector;

import static com.epam.quadrangle.entity.QuadrangleType.*;

public class Calculator {

    public QuadrangleType defineTypeOfQuadrangle(Quadrangle quadrangle) {
        Point pointA = quadrangle.getPointA();
        Point pointB = quadrangle.getPointB();
        Point pointC = quadrangle.getPointC();
        Point pointD = quadrangle.getPointD();
        Vector vectorAB = new Vector(pointA, pointB);
        Vector vectorBC = new Vector(pointB, pointC);
        Vector vectorCD = new Vector(pointC, pointD);
        Vector vectorDA = new Vector(pointD, pointA);

        if (areVectorsParallel(vectorAB, vectorCD) && vectorAB.equals(vectorCD)) {
            if (vectorAB.equals(vectorBC)) {
                if (areVectorsPerpendicular(vectorAB, vectorBC)) {
                    return SQUARE;
                }
                return RHOMBUS;
            }
            return RECTANGLE;
        } else if (areVectorsParallel(vectorAB, vectorCD) || areVectorsParallel(vectorBC, vectorDA)) {
            return TRAPEZE;
        }
        return IRREGULAR;
    }

    public boolean areVectorsPerpendicular(Vector firstVector, Vector secondVector) {
        return calculateVectorScalarMultiplication(firstVector, secondVector) == 0;
    }

    public boolean areVectorsParallel(Vector firstVector, Vector secondVector) {
        double vectorOneEndGetX = firstVector.getVectorEnd().getX();
        double vectorOneBeginGetX = firstVector.getVectorBegin().getX();
        double vectorOneEndGetY = firstVector.getVectorEnd().getY();
        double vectorOneBeginGetY = firstVector.getVectorBegin().getY();
        double vectorTwoEndGetX = secondVector.getVectorEnd().getX();
        double vectorTwoBeginGetX = secondVector.getVectorBegin().getX();
        double vectorTwoEndGetY = secondVector.getVectorEnd().getY();
        double vectorTwoBeginGetY = secondVector.getVectorBegin().getY();

        double xDesignFromVectorOne = vectorOneEndGetX - vectorOneBeginGetX;
        double yDesignFromVectorOne = vectorOneEndGetY - vectorOneBeginGetY;
        double xDesignFromVectorTwo = vectorTwoEndGetX - vectorTwoBeginGetX;
        double yDesignFromVectorTwo = vectorTwoEndGetY - vectorTwoBeginGetY;

        return xDesignFromVectorOne / xDesignFromVectorTwo == yDesignFromVectorOne / yDesignFromVectorTwo;
    }

    public double calculateVectorScalarMultiplication(Vector firstVector, Vector secondVector) {
        double vectorOneEndGetX = firstVector.getVectorEnd().getX();
        double vectorOneBeginGetY = firstVector.getVectorBegin().getY();
        double vectorTwoEndGetX = secondVector.getVectorEnd().getX();
        double vectorTwoBeginGetX = secondVector.getVectorBegin().getX();
        double vectorOneEndGetY = firstVector.getVectorEnd().getY();
        double vectorTwoEndGetY = secondVector.getVectorEnd().getY();
        double vectorTwoBeginGetY = secondVector.getVectorBegin().getY();

        double xToCalculateFirst = vectorOneEndGetX - vectorOneBeginGetY;
        double xToCalculateSecond = vectorTwoEndGetX - vectorTwoBeginGetX;
        double yToCalculateFirst = vectorOneEndGetY - vectorOneBeginGetY;
        double yToCalculateSecond = vectorTwoEndGetY - vectorTwoBeginGetY;

        return (xToCalculateFirst * xToCalculateSecond) + (yToCalculateFirst * yToCalculateSecond);
    }

    public double calculateQuadranglePerimeter(Quadrangle quadrangle) {
        Vector vectorAB = new Vector(quadrangle.getPointA(), quadrangle.getPointB());
        Vector vectorBC = new Vector(quadrangle.getPointB(), quadrangle.getPointC());
        Vector vectorCD = new Vector(quadrangle.getPointC(), quadrangle.getPointD());
        Vector vectorDA = new Vector(quadrangle.getPointD(), quadrangle.getPointA());
        double vectorABLength = calculateVectorLength(vectorAB);
        double vectorBCLength = calculateVectorLength(vectorBC);
        double vectorCDLength = calculateVectorLength(vectorCD);
        double vectorDALength = calculateVectorLength(vectorDA);

        return vectorABLength + vectorBCLength + vectorCDLength + vectorDALength;
    }

    public double calculateVectorLength(Vector vector) {
        double xBegin = vector.getVectorBegin().getX();
        double xEnd = vector.getVectorEnd().getX();
        double yBegin = vector.getVectorBegin().getY();
        double yEnd = vector.getVectorEnd().getY();

        double xCommon = xEnd - xBegin;
        double yCommon = yEnd - yBegin;
        double vectorLength = Math.sqrt((xCommon * xCommon) + (yCommon * yCommon));

        return vectorLength;
    }

    public double calculateQuadrangleSquare(Quadrangle quadrangle) {
        Vector vectorAB = new Vector(quadrangle.getPointA(), quadrangle.getPointB());
        Vector vectorBC = new Vector(quadrangle.getPointB(), quadrangle.getPointC());
        Vector vectorCD = new Vector(quadrangle.getPointC(), quadrangle.getPointD());
        Vector vectorDA = new Vector(quadrangle.getPointD(), quadrangle.getPointA());

        double halfPerimeter = calculateQuadranglePerimeter(quadrangle) / 2;
        double firstPart = (halfPerimeter - calculateVectorLength(vectorAB)) * (halfPerimeter - calculateVectorLength(vectorBC));
        double secondPart = (halfPerimeter - calculateVectorLength(vectorCD)) * (halfPerimeter - calculateVectorLength(vectorDA));

        return Math.sqrt(firstPart * secondPart);
    }
}
