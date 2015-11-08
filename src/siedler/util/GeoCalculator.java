package siedler.util;

import com.google.inject.Guice;
import com.google.inject.Injector;

import basic.IPoint;
import basic.IShape;
import basic.imp.BasicModule;

public class GeoCalculator {

	private static final Injector INJ = Guice.createInjector(new BasicModule());

	private GeoCalculator() {
	}

	public static IPoint calcMid(IShape s) {
		IPoint p = INJ.getInstance(IPoint.class);
		double x = (s.getXMin() + s.getXMax()) / 2;
		double y = (s.getYMin() + s.getYMax()) / 2;
		p.initWithXY(x, y);
		return p;
	}

	public static double calcSquareDistance(IPoint p, IPoint q) {
		double dx = q.getX() - p.getX();
		double dy = q.getY() - p.getY();
		return dx * dx + dy * dy;
	}

}
