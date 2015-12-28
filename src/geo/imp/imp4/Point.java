package geo.imp.imp4;

import java.util.Locale;

import geo_old.IPoint;
import geo_old.IVector;

final class Point implements IPoint {

    private double x = 0;
    private double y = 0;

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double distanceTo(final IPoint other) {
        return Math.sqrt(distanceSquareTo(other));
    }

    @Override
    public double distanceSquareTo(final IPoint other) {
        return (x - other.getX()) * (x - other.getX()) + (y - other.getY())
                * (y - other.getY());
    }

    @Override
    public void set(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void copy(final IPoint other) {
        this.x = other.getX();
        this.y = other.getY();
    }

    @Override
    public void move(final IVector v) {
        x += v.getX();
        y += v.getY();
    }

    @Override
    public void rotateAround(final double angleDeg, final IPoint pivot) {
        double angleRad = Math.toRadians(angleDeg);
        double sin = Math.sin(angleRad);
        double cos = Math.cos(angleRad);

        x -= pivot.getX();
        y -= pivot.getY();

        double xn = x * cos - y * sin;
        double yn = x * sin + y * cos;

        x = xn + pivot.getX();
        y = yn + pivot.getY();
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "(%.3f|%.3f)", getX(), getY());
    }

}
