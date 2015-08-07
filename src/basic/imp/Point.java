package basic.imp;

import java.util.Locale;

import basic.IPoint;
import basic.IVector;
import basic.IShape;

final class Point implements IPoint {

    private double x, y;
    
    @Override
    public void initWithXY(double x, double y) {
       this.x = x;
       this.y = y;
    }

    @Override
    public void initByCopying(IPoint other) {
        x = other.getX();
        y = other.getY();
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void move(IVector movement) {
        x += movement.getX();
        y += movement.getY();
    }

    @Override
    public void rotate(IPoint pivot, double radian) {
        x -= pivot.getX();
        y -= pivot.getY();
        
        double sin = Math.sin(radian);
        double cos = Math.cos(radian);

        double xn = x * cos - y * sin;
        double yn = x * sin + y * cos;

        x = xn + pivot.getX();
        y = yn + pivot.getY();
    }

    
    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "(%.3f|%.3f)", getX(), getY());
    }



	@Override
	public double getXMin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getYMin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getXMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getYMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addParent(IShape s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeParent(IShape s) {
		// TODO Auto-generated method stub
		
	}




}
