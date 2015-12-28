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
public class Point implements IPoint {

    private double x, y;

    private final List<AbstractBoundingBox> parents = new ArrayList<>();

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
        return (x * x) + (y * y);
    }

    public void move(final IVector v) {
        x += v.getX();
        y += v.getY();
        notifyParents();
    }

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

    void addParent(AbstractBoundingBox parent) {
        parents.add(parent);
    }

    void removeParent(AbstractBoundingBox parent) {
        parents.remove(parent);
    }

    private void notifyParents() {
        for (AbstractBoundingBox parent : parents) {
            parent.notifyUpdate();
        }
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "(%.3f|%.3f)", getX(), getY());
    }

}
