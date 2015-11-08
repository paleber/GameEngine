package demo;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;

import basic.ILine;
import basic.IPoint;
import basic.IPolygon;
import basic.IVector;
import basic.imp.BasicModule;

public class BoardBuilder {

	// Dreiecke: 3 Ecken Winkel 120°, 6 an einem Punkt 120° = 2PI/6 60
	// Quadrat: 4 Ecken Winkel 90° , 4 an einem Punkt 90° = 2PI/4 90
	// Hexagon: 6 Ecken Winkel 60° , 3 an einem Punkt 60° = 2PI/3 120

	private int numCorners;
	private int numPolys;

	public enum Shape {
		Triangle, Square, Hexagon;
	}

	private static final Injector INJ = Guice.createInjector(new BasicModule());

	private final List<IPoint> points = new ArrayList<>();
	private final List<ILine> lines = new ArrayList<>();
	private final List<ExtendedPoly> epolys = new ArrayList<>();

	public void build(Shape s, int deep, int numStartPolys) {
		switch (s) {
		case Triangle:
			numCorners = 3;
			numPolys = 6;
			break;
		case Square:
			numCorners = 4;
			numPolys = 4;
			break;
		case Hexagon:
			numCorners = 6;
			numPolys = 3;
			break;
		default:
			break;
		}

		buildCore(deep, numStartPolys);

		for (int i = 0; i < epolys.size() && i < 10000; i++) {
			if(epolys.get(i).value <= 0) {
				break;
			}
			multiply(epolys.get(i));
		}

	}
	
	// Baut alle Nachbarn eines einzelnen Polygons
	private void multiply(ExtendedPoly poly) {
		//for(int i = 0; i < poly.getNumberElements(); i++) {
			
		//}
		for(int i = 0; i < numCorners; i++) {
			for(int j = 0; j < numPolys; j++) {
				IPolygon copy = INJ.getInstance(IPolygon.class);
				copy.initByCopying(poly.poly);
				
				copy.rotate(poly.poly.getPoint(i), j * 2 * Math.PI / numPolys);
				epolys.add(new ExtendedPoly(copy, poly.value - 1));
				
			}
		}
		
		
		
		
		
		
		
	}
	

	private static final class ExtendedPoly {

		private final IPolygon poly;
		private int value; // Anzahl weitere Polygon nach außen

		private ExtendedPoly(IPolygon poly, int value) {
			this.poly = poly;
			this.value = value;
		}

		private boolean equals(IPolygon poly) {
			return false; // TODO
		}

	}

	private void buildCore(int deep, int startPolys) {

		IPoint[] p = new IPoint[numCorners];
		for (int i = 0; i < p.length; i++) {
			p[i] = INJ.getInstance(IPoint.class);
		}

		p[0].initWithXY(100, 100);

		IVector v = INJ.getInstance(IVector.class);
		v.initWithXY(-10, 0);

		for (int i = 1; i < p.length; i++) {
			v.rotate(2 * Math.PI / numCorners);
			p[i].initByCopying(p[i - 1]);
			p[i].move(v);
		}

		IPolygon poly = INJ.getInstance(IPolygon.class);
		poly.initWithPoints(p);
		epolys.add(new ExtendedPoly(poly, deep));

		for (int i = 1; i < startPolys; i++) {
			IPolygon copy = INJ.getInstance(IPolygon.class);
			copy.initByCopying(poly);
			copy.rotate(p[0], i * 2 * Math.PI / numPolys);
			epolys.add(new ExtendedPoly(copy, deep));
		}
	}

	public List<IPoint> getPoints() {
		return points;
	}

	public List<ILine> getLines() {
		return lines;
	}

	public List<IPolygon> getPolygons() {
		List<IPolygon> list = new ArrayList<>();
		for (ExtendedPoly p : epolys) {
			list.add(p.poly);
		}
		return list;
	}

}
