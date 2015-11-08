package siedler.builder;

import siedler.model.Intersection;
import siedler.model.Path;
import siedler.model.Terrain;

public interface IBoardBuilder {

	public void build();
	
	public Terrain[] getTerrain();

	public Intersection[] getIntersections();
	
	public Path[] getPaths();
	
	
}
