package geo.imp;

import geo.basic.IBoundingBoxCollider.IBoundingBox;
import geo.basic.IPoint;

@Deprecated
public final class BoundingBox  {
    
    private double xMin, xMax, yMin, yMax;

    public void update(final IPoint... points) {
        xMin = points[0].getX();
        xMax = points[0].getX();
        yMin = points[0].getY();
        yMax = points[0].getY();
        for (int i = 1; i < points.length; i++) {
            xMin = Math.min(xMin, points[i].getX());
            xMax = Math.max(xMax, points[i].getX());
            yMin = Math.min(yMin, points[i].getY());
            yMax = Math.max(yMax, points[i].getY());
        }
    }

    public boolean collideWith(final IBoundingBox other) {
        if (xMin > other.getXMax() || xMax < other.getXMin()) {
            return false;
        }
        if (yMin > other.getYMax() || yMax < other.getYMin()) {
            return false;
        }
        return true;
    }

    public double getXMin() {
        return xMin;
    }

    public double getXMax() {
        return xMax;
    }

    public double getYMin() {
        return yMin;
    }

  
    public double getYMax() {
        return yMax;
    }

}