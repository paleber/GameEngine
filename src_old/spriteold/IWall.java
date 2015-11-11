package spriteold;

import geo_old.IPolygon;

public interface IWall extends ISprite<IPolygon> {
    
    void init(final IPolygon poly);
    
}
