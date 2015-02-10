package geo.imp;

import geo.basic.IBoundingBox;
import geo.basic.IBoundingBoxFix;
import geo.basic.IPoint;
import geo.shape.ILine;

public class Line implements ILine {

    private IPoint start;
    private IPoint end;

    private final IBoundingBox bb = new BoundingBox();

    @Override
    public IPoint getStart() {
        return start;
    }

    @Override
    public IPoint getEnd() {
        return end;
    }

    @Override
    public void setPoints(IPoint start, IPoint end) {
        this.start = start;
        this.end = end;
        bb.update(start, end);
    }

    @Override
    public IBoundingBoxFix getBoundingBox() {
        return bb;
    }

}
