package spriteold;

import java.util.Iterator;

import geo_old.IPoint;
import geo_old.IPolygon;
import collision_old.IBoundingBox;

public class Wall implements IWall {

    private IPolygon poly;
    private BoundingBox bb = new BoundingBox();

    private double xMin, yMin, xMax, yMax;

    private final class BoundingBox implements IBoundingBox {

        @Override
        public double getXMin() {
            return xMin;
        }

        @Override
        public double getXMax() {
            return xMax;
        }

        @Override
        public double getYMin() {
            return yMin;
        }

        @Override
        public double getYMax() {
            return yMax;
        }

    }

    @Override
    public void init(final IPolygon poly) {
        this.poly = poly;

        xMin = Double.POSITIVE_INFINITY;
        xMax = Double.NEGATIVE_INFINITY;
        yMin = Double.POSITIVE_INFINITY;
        yMax = Double.NEGATIVE_INFINITY;

        Iterator<IPoint> it = poly.getPointIterator();
        while (it.hasNext()) {
            IPoint p = it.next();
            xMin = Math.min(xMin, p.getX());
            xMax = Math.max(xMax, p.getX());
            yMin = Math.min(yMin, p.getY());
            yMax = Math.max(yMax, p.getY());
        }

    }

    @Override
    public IPolygon getShape() {
        return poly;
    }

    @Override
    public IBoundingBox getBoundingBox() {
        return bb;
    }

}
