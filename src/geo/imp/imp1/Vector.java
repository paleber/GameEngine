package geo.imp.imp1;

import java.util.Locale;

import basic.IPoint;
import basic.IVector;

final class Vector implements IVector {

    private static final double FULL_ROTATION = 2 * Math.PI;
    
    private double radian, length;
    
    @Override
    public void initWithXY(double x, double y) {
        radian = Math.atan2(y, x);
        limitAngle();
        length = Math.sqrt(x * x + y * y);
    }

    @Override
    public void initWithAngleAndLength(double radian, double length) {
        this.radian = radian;
        this.length = length;
        limitAngle();
    }

    @Override
    public void initByCopying(IVector other) {
        radian = other.getAngle();
        length = other.getLength();
    }

    @Override
    public void initByStretching(IPoint start, IPoint end) {
        initWithXY(end.getX() - start.getX(), end.getY() - start.getY());
    }

    @Override
    public double getX() {
        return Math.cos(radian) * length;
    }

    @Override
    public double getY() {
        return Math.sin(radian) * length;
    }

    @Override
    public double getLength() {
        return length;
    }

    @Override
    public double getAngle() {
        return radian;
    }

    @Override
    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public void rotate(double radian) {
        this.radian += radian;
        limitAngle();
    }

    private void limitAngle() {
        radian = radian % FULL_ROTATION;
        if (radian < 0) {
            radian += FULL_ROTATION;
        }
    }
    
    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "<%.3f|%.3f>", getX(), getY());
    }
}
