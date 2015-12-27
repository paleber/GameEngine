package siedler.model;

import basic.ILine;
import siedler.util.IdGenerator;

public class Path {

	private final int id = IdGenerator.generate();
	
	private ILine line;
	
	private Path[] nextPaths;

	private Intersection neighbors;
	
	private Player owner = null;
}
