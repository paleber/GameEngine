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

    private IPolygon[] polys = new PolygonBuilder().getPolygons();

    public IPolygon[] getPolys() {
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
