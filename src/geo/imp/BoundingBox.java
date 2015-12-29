package geo.imp;

import geo.IBoundingBox;
import geo.IPoint;

/**
 * Abstract class for BoundingBox.
 */
abstract class BoundingBox implements IBoundingBox {

    private double xMin, xMax, yMin, yMax;
    private boolean doUpdate = true;

    void updateBoundingBox() {
        doUpdate = true;
    }

    @Override
    public double getXMin() {
        checkUpdate();
        return xMin;
    }

    @Override
    public double getXMax() {
        checkUpdate();
        return xMax;
    }

    @Override
    public double getYMin() {
        checkUpdate();
        return yMin;
    }

    @Override
    public double getYMax() {
        checkUpdate();
        return yMax;
    }

    private void checkUpdate() {
        if (doUpdate) {
            xMin = updateXMin();
            xMax = updateXMax();
            yMin = updateYMin();
            yMax = updateYMax();
            doUpdate = false;
        }
    }

    @Override
    public IPoint calculateMid() {
        return new Point((getXMin() + getXMax()) / 2, (getYMin() + getYMax()) / 2);
    }

    abstract double updateXMin();

    abstract double updateXMax();

    abstract double updateYMin();

    abstract double updateYMax();

}
