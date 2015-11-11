package collision_old;

import geo_old.ICircle;
import geo_old.ILine;
import geo_old.IPoint;
import geo_old.IVector;
import geo_old.imp.GeoModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

public final class Collision {

    private static final Injector INJECTOR = Guice
            .createInjector(new GeoModule());

    private Collision() {
    }

    public static boolean checkBoundingBoxes(final IBoundingBox bb1,
            final IBoundingBox bb2) {

        if (bb1.getXMin() > bb2.getXMax() || bb1.getXMax() < bb2.getXMin()) {
            return false;
        }
        return !(bb1.getYMin() > bb2.getYMax() || bb1.getYMax() < bb2.getYMin());
    }

    // Collision detection with projection
    public static boolean check(ILine l, ICircle circle) {

        
        
        IPoint circ_pos = circle.getMid();
        IPoint seg_a = l.getStart();
        IPoint seg_b = l.getEnd();
        
        IVector seg_v = INJECTOR.getInstance(IVector.class);
        seg_v.stretchBetween(seg_a, seg_b);
        
        IVector pt_v = INJECTOR.getInstance(IVector.class);
        pt_v.stretchBetween(seg_a, circ_pos);
        
        double proj_v = pt_v.dotProduct(seg_v) / seg_v.getLength();
        
        IPoint closest;
        if(proj_v < 0 ) {
            closest = seg_a;
        } else if(proj_v > seg_v.getLength()) {
            closest = seg_b;
        } else {
            seg_v.setLength(proj_v);
            closest = INJECTOR.getInstance(IPoint.class);
            closest.copy(seg_a);
            closest.move(seg_v);
        }
        
        System.out.println(closest);
        
        return check(closest, circle);
        
    }

    public static boolean check(IPoint p, ICircle circle) {

        return p.distanceSquareTo(circle.getMid()) < circle.getRadius()
                * circle.getRadius();

    }

    

    /*
     * public static boolean check(ILine l, ICircle circle) {
     * 
     * 
     * 
     * // Kollision der Bounding-Boxen pr�fen
     * if(!l.getBoundingBox().collide(c.getBoundingBox())) { return false; }
     */

    /*
     * / Pr�fen, ob Anfangspunkt der Linie im Kreis liegt
     * if(l.getPoint(0).getDistanceToPointSq(c.getMid()) <= c.getRadiusSq()) {
     * return true; }
     */
    /*
     * / Pr�fen, ob Endpunkt der Linie im Kreis liegt
     * if(l.getPoint(1).getDistanceToPointSq(c.getMid()) <= c.getRadiusSq()) {
     * return true; } /
     * 
     * 
     * // 2 Vektoren erstellen IVector dir =
     * INJECTOR.getInstance(IVector.class); IVector normal =
     * INJECTOR.getInstance(IVector.class);
     * 
     * dir.set(x, y);
     * 
     * 
     * 
     * a.init(l.getPoint(0), l.getPoint(1)); // Vektor der Strecke
     * b.init(l.getPoint(0), c.getMid()); // Vektor AP zu Kreismitte // Nahester
     * Punkt (v = x+at) t = a.getSkalarProduct(b) / a.getSkalarProduct(a); //
     * Punkt liegt au�erhalb if(t < 0 || t > 1) { return false; // Punkt liegt
     * drin, Abstand berechnen } else { p.init(l.getPoint(0)); v.init(a.getX(),
     * a.getY()); v.multSkalar(t); p.move(v); // Linie schneidet
     * if(p.getDistanceToPointSq(c.getMid()) <= c.getRadiusSq()) { return true;
     * } // Linie schneidet nicht return false; }
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * // TODO Auto-generated method stub return false; }
     */

}
