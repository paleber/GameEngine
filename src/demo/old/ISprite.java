package demo.old;

import geo_old.IShape;
import collision.IBoundingBox;

public interface ISprite<T extends IShape> {

    T getShape();
    
    IBoundingBox getBoundingBox();
    
}
