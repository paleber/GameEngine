package geo.imp;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

import geo.ILine;
import geo.IPoint;

/**
 * Implementation of Line.
 */
final class Line extends BoundingBox implements ILine {

    private final Point start, end;

    @AssistedInject
    Line(@Assisted("s") final IPoint start, @Assisted("e") final IPoint end) {
        this.start = (Point) start;
        this.end = (Point) end;
        addAsParent();
    }

    @AssistedInject
    Line(@Assisted final ILine other) {
        start = new Point(other.getStart());
        end = new Point(other.getEnd());
        addAsParent();
    }

    private void addAsParent() {
        start.addParent(this);
        end.addParent(this);
    }

    @Override
    double updateXMin() {
        return Math.min(start.getX(), end.getX());
    }

    @Override
    double updateXMax() {
        return Math.max(start.getX(), end.getX());
    }

    @Override
    double updateYMin() {
        return Math.min(start.getY(), end.getY());
    }

    @Override
    double updateYMax() {
        return Math.max(start.getY(), end.getY());
    }

    @Override
    public IPoint getStart() {
        return start;
    }

    @Override
    public IPoint getEnd() {
        return end;
    }

    @Override
    public IPoint getOtherPoint(IPoint p) {
        if (p == start) {
            return end;
        }
        if (p == end) {
            return start;
        }
        return null;
    }

    @Override
    public String toString() {
        return "<" + start + end + ">";
    }

    /*
    private final Iterable<IPoint> pointIterator =  () -> new Iterator<IPoint>() {
        int i = 0;

        @Override
        public boolean hasNext() {
            return i < points.length;
        }

        @Override
        public IPoint next() {
            return points[i++];
        }
    }; */

}
