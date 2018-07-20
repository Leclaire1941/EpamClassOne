package com.epam.quadrangle.entity;

public class Vector {
    private Point vectorBegin;
    private Point vectorEnd;

    public Vector(Point vectorBegin, Point vectorEnd) {
        this.vectorBegin = vectorBegin;
        this.vectorEnd = vectorEnd;
    }

    public Point getVectorBegin() {
        return vectorBegin;
    }
    public Point getVectorEnd() {
        return vectorEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;

        Vector other = (Vector) o;
        if (vectorBegin.equals(other.vectorBegin)) return false;
        return vectorEnd.equals(other.vectorEnd);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + vectorBegin.hashCode();
        result = prime * result + vectorEnd.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "vectorBegin=" + vectorBegin +
                ", vectorEnd=" + vectorEnd +
                '}';
    }
}
