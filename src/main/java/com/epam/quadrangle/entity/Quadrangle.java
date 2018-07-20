package com.epam.quadrangle.entity;

public class Quadrangle {
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;
    private QuadrangleType typeOfQuadrangle;

    public Quadrangle(Point pointA, Point pointB, Point pointC, Point pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
    }

    public Quadrangle(Point pointA, Point pointB, Point pointC, Point pointD, QuadrangleType typeOfQuadrangle) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
        this.typeOfQuadrangle = typeOfQuadrangle;
    }

    public QuadrangleType getTypeOfQuadrangle() {
        return typeOfQuadrangle;
    }
    public Point getPointA() {
        return pointA;
    }
    public Point getPointB() {
        return pointB;
    }
    public Point getPointC() {
        return pointC;
    }
    public Point getPointD() {
        return pointD;
    }

    @Override
    public String toString() {
        return "Quadrangle{" +
                "pointA=" + pointA +
                ", pointB=" + pointB +
                ", pointC=" + pointC +
                ", pointD=" + pointD +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        Quadrangle other = (Quadrangle) o;
        if (!pointA.equals(other.pointA)) return false;
        if (!pointB.equals(other.pointB))return false;
        if (!pointC.equals(other.pointC))return false;

        return pointD.equals(other.pointD);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (pointA.hashCode());
        result = prime * result + (pointB.hashCode());
        result = prime * result + (pointC.hashCode());
        result = prime * result + (pointD.hashCode());
        return result;
    }
}
