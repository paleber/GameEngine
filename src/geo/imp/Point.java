package geo.imp;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import geo.IPoint;
import geo.IVector;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Implementation of Point.
 */
final class Point implements IPoint {

    private double x, y;

    private final List<BoundingBox> parents = new ArrayList<>();

    @AssistedInject
    Point(@Assisted("x") final double x, @Assisted("y") final double y) {
        this.x = x;
        this.y = y;
    }

    @AssistedInject
    Point(@Assisted final IPoint other) {
        x = other.getX();
        y = other.getY();
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double distanceTo(IPoint other) {
        return Math.sqrt(squareDistanceTo(other));
    }

    @Override
    public double squareDistanceTo(final IPoint other) {
        double dx = other.getX() - x;
        double dy = other.getY() - y;
        return (dx * dx) + (dy * dy);
    }

    @Override
    public void move(final IVector v) {
        x += v.getX();
        y += v.getY();
        notifyParents();
    }

    @Override
    public void rotate(final IPoint pivot, final double radian) {
        x -= pivot.getX();
        y -= pivot.getY();

        double sin = Math.sin(radian);
        double cos = Math.cos(radian);

        double xn = x * cos - y * sin;
        double yn = x * sin + y * cos;

        x = xn + pivot.getX();
        y = yn + pivot.getY();
        notifyParents();
    }

    void addParent(BoundingBox parent) {
        parents.add(parent);
    }

    void removeParent(BoundingBox parent) {
        parents.remove(parent);
        System.out.println(parents.size());
    }

    private void notifyParents() {
        parents.forEach(BoundingBox::updateBoundingBox);
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "(%.3f|%.3f)", getX(), getY());
    }

}
