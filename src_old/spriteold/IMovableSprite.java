package spriteold;

import geo_old.ICircle;
import geo_old.IPolygon;
import geo_old.IShape;

public interface IMovableSprite<T extends IShape> extends ISprite<T> {

    void move();

    void collideWith(ICircle circle);

    void collideWith(IPolygon poly);

}
