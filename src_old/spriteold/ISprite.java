package spriteold;

import geo_old.IShape;
import collision_old.IBoundingBox;

public interface ISprite<T extends IShape> {

    T getShape();
    
    IBoundingBox getBoundingBox();
    
}
