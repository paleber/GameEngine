package spriteold;

import geo_old.ICircle;
import geo_old.IPoint;
import time_old.tpf.ITpfCounter;

public interface IBall extends IMovableSprite<ICircle> {

    void init(IPoint mid, double angle, double speed, ITpfCounter tpfCounter);

}
