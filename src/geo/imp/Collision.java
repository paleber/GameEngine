package geo.imp;

import geo.basic.IBoundingBoxCollider;
import geo.basic.IBoundingBoxCollider.IBoundingBox;

public final class Collision {

    private Collision() {}
    
    public static boolean checkBoundingBoxCollides(IBoundingBoxCollider bbc1,
            IBoundingBoxCollider bbc2) {

        IBoundingBox bb1 = bbc1.getBoundingBox();
        IBoundingBox bb2 = bbc2.getBoundingBox();

        if (bb1.getXMin() > bb2.getXMax() || bb1.getXMax() < bb2.getXMin()) {
            return false;
        }
        if (bb1.getYMin() > bb2.getYMax() || bb1.getYMax() < bb2.getYMin()) {
            return false;
        }
        return true;
    }

}
