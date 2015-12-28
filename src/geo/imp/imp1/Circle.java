package geo.imp.imp1;

import java.util.Locale;

import basic.ICircle;
import basic.IPoint;
import basic.IVector;

public class Circle extends ComplexShape implements ICircle{

    private Point mid;
    private double radius;
    
    @Override
    protected void update() {}

    @Override
    public void move(IVector v) {
        mid.move(v);
    }
    
    @Override
    public void rotate(IPoint pivot, double radian) {
        mid.rotate(pivot, radian);
    }

    @Override
    public double getXMin() {
        return mid.getX() - radius;
    }

    @Override
    public double getYMin() {
        return mid.getY() - radius;
    }

    @Override
    public double getXMax() {
        return mid.getX() + radius;
    }

    @Override
    public double getYMax() {
        return mid.getY() + radius;
    }

    @Override
    public void init(IPoint mid, double radius) {
       removeAsParent(this.mid);
       this.mid = (Point) mid;
       this.radius = radius;
       addAsParent(this.mid);
    }

    @Override
    public IPoint getMid() {
        return mid;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "<%sr=%.3f>", mid.toString(), radius);
    }
    
}
