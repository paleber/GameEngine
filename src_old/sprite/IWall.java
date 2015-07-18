package sprite;

import geo.IPolygon;

public interface IWall extends ISprite<IPolygon> {
    
    void init(final IPolygon poly);
    
}
