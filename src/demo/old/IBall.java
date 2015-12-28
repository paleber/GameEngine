package demo.old;

import geo_old.ICircle;
import geo_old.IPoint;
import time.tpf.ITpfCounter;

public interface IBall extends IMovableSprite<ICircle> {

    void init(IPoint mid, double angle, double speed, ITpfCounter tpfCounter);

}
