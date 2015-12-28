package geo.imp;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

import geo.ICircle;
import geo.IPoint;
import geo.IVector;

import java.util.Locale;

/**
 * Implementation of Circle.
 */
public class Circle extends AbstractBoundingBox implements ICircle {

    private final Point mid;
    private final double radius;

    @AssistedInject
    Circle(@Assisted final IPoint mid, @Assisted final double radius) {
        this.mid = (Point) mid;
        this.radius = radius;
        this.mid.addParent(this);
    }

    @AssistedInject
    Circle(@Assisted final ICircle other) {
        mid = new Point(other.getMid());
        radius = other.getRadius();
        mid.addParent(this);
    }

    @Override
    public void move(final IVector v) {
        mid.move(v);
        notifyUpdate();
    }

    @Override
    public void rotate(final IPoint pivot, final double radian) {
        mid.rotate(pivot, radian);
        notifyUpdate();
    }

    @Override
    double updateXMin() {
        return mid.getX() - radius;
    }

    @Override
    double updateXMax() {
        return mid.getX() + radius;
    }

    @Override
    double updateYMin() {
        return mid.getY() - radius;
    }

    @Override
    double updateYMax() {
        return mid.getY() + radius;
    }

    @Override
    public IPoint getMid() {
        return mid;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "<%sr=%.3f>", mid.toString(),
                radius);
    }

}
