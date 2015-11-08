package siedler.builder;

import java.util.LinkedList;
import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;

import basic.IPoint;
import basic.IPolygon;
import basic.IVector;
import basic.imp.BasicModule;
import siedler.model.Intersection;
import siedler.model.Path;
import siedler.model.Terrain;
import siedler.util.GeoCalculator;

public class StandardBoardBuilder implements IBoardBuilder {

	private static final Injector INJ = Guice.createInjector(new BasicModule());

	private List<IPolygon> polys = new LinkedList<>();

	@Override
	public void build() {
		buildCore();
		buildRing();
		buildRing();
	}

	private void buildCore() {
		IVector v = INJ.getInstance(IVector.class);
		v.initWithXY(1, 0);
		IPoint[] p = new IPoint[6];

		for (int i = 0; i < p.length; i++) {
			p[i] = INJ.getInstance(IPoint.class);
		}

		p[0].initWithXY(5, 5);

		for (int i = 1; i < p.length; i++) {
			p[i].initByCopying(p[i - 1]);
			p[i].move(v);
			System.out.println(Math.toDegrees(v.getAngle()));
			v.rotate(Math.PI / 3);
		}

		IPolygon poly = INJ.getInstance(IPolygon.class);
		poly.initWithPoints(p);
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
					list.add(poly);
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
				
				System.out.println(m + "" + n);
				
				return;
			}
		}

		polys.add(p);
	}

	// For testing
	public List<IPolygon> getPolys() {
		return polys;
	}

	@Override
	public Terrain[] getTerrain() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Intersection[] getIntersections() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Path[] getPaths() {
		// TODO Auto-generated method stub
		return null;
	}

}
