package siedler.builder;

import siedler.model.Intersection;
import siedler.model.Path;
import siedler.model.Terrain;

public interface IBoardBuilder {

	void build();
	
	Terrain[] getTerrain();

	Intersection[] getIntersections();
	
	Path[] getPaths();
	
	
}
