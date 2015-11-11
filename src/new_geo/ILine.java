package new_geo;

import java.util.Iterator;

public interface ILine extends IBoundingBox {

	Iterator<IPoint> iteratePoints();
	
}
