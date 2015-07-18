package sprite;

import geo.IShape;
import collision.IBoundingBox;

public interface ISprite<T extends IShape> {

    T getShape();
    
    IBoundingBox getBoundingBox();
    
}
