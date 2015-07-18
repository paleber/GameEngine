package sprite;

import geo.ICircle;
import geo.IPolygon;
import geo.IShape;

public interface IMovableSprite<T extends IShape> extends ISprite<T> {

    void move();

    void collideWith(ICircle circle);

    void collideWith(IPolygon poly);

}
