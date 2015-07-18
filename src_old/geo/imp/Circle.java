package geo.imp;

import geo.ICircle;
import geo.IPoint;
import geo.IVector;

final class Circle implements ICircle {

    private IPoint mid;
    private double radius;

    @Override
    public void move(final IVector v) {
        mid.move(v);
    }

    @Override
    public void rotateAround(final double angleDeg, final IPoint pivot) {
        mid.rotateAround(angleDeg, pivot);
    }

    @Override
    public void setMid(final IPoint mid) {
        this.mid = mid;
    }

    @Override
    public IPoint getMid() {
        return mid;
    }

    @Override
    public void setRadius(final double radius) {
        this.radius = radius;
    }

    @Override
    public double getRadius() {
        return radius;
    }

}
