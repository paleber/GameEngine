package siedler.model;

import basic.IPoint;
import siedler.util.IdGenerator;

public class Intersection {

	private final int id = IdGenerator.generate();
	
	private IPoint p;
	
	private Intersection[] nextIntersections;
	private Path[] nextPaths;
	
	private Player owner;



	public Intersection(IPoint p) {

    }

    public void addNeighbor(Intersection inter) {

    }

    public void addPath(Path path) {

    }

}
