package siedler.builder;

import basic.IPoint;
import basic.IPolygon;
import basic.IVector;
import basic.imp.BasicModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import siedler.util.GeoCalculator;

import java.util.LinkedList;
import java.util.List;

public class PolygonBuilder {

    private static final Injector INJ = Guice.createInjector(new BasicModule());

    private List<IPolygon> polys = new LinkedList<>();

    public PolygonBuilder() {
        buildCore();
        buildRing();
        buildRing();
    }

    private void buildCore() {
        IVector v = INJ.getInstance(IVector.class);
        v.initWithXY(1, 0);
        v.rotate(Math.PI / 6);
        IPoint[] p = new IPoint[6];

        for (int i = 0; i < p.length; i++) {
            p[i] = INJ.getInstance(IPoint.class);
        }

        p[0].initWithXY(5, 5);

        for (int i = 1; i < p.length; i++) {
            p[i].initByCopying(p[i - 1]);
            p[i].move(v);
            v.rotate(Math.PI / 3);
        }

        IPolygon poly = INJ.getInstance(IPolygon.class);
        poly.initWithPoints(p);

        IPoint q = INJ.getInstance(IPoint.class);
        q.initWithXY((poly.getXMin() + poly.getXMax()) / 2, (poly.getYMin() + poly.getYMax()) / 2);

        v.initByStretching(q, p[0]);
        poly.move(v);

        addPoly(poly);
    }

    private void buildRing() {
        List<IPolygon> list = new LinkedList<>();

        for (IPolygon poly : polys) {
            for (int i = 0; i < poly.getNumberElements(); i++) {
                for (int j = 0; j < 3; j++) {
                    IPolygon copy = INJ.getInstance(IPolygon.class);
                    copy.initByCopying(poly);
                    copy.rotate(poly.getPoint(i), j * 2 * Math.PI / 3);
                    list.add(copy);
                }
            }

        }

        for(IPolygon poly: list) {
            addPoly(poly);
        }

    }

    private void addPoly(IPolygon p) {
        IPoint m = GeoCalculator.calcMid(p);

        for (IPolygon poly : polys) {
            IPoint n = GeoCalculator.calcMid(poly);
            if (GeoCalculator.calcSquareDistance(m, n) < 1e-3) {
                return;
            }
        }
        polys.add(p);
    }

    // For testing
    public IPolygon[] getPolygons() {
        IPolygon[] a = new IPolygon[polys.size()];
        for (int i = 0; i < polys.size(); i++) {
            a[i] = polys.get(i);
        }
        return a;
    }


}
