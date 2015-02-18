package sprite;

import geo.ICircle;
import geo.IPoint;
import time.tpf.ITpfCounter;

public interface IBall extends IMovableSprite<ICircle> {

    void init(IPoint mid, double angle, double speed, ITpfCounter tpfCounter);

}
