package basic.imp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import basic.IPoint;
import basic.IPolygon;
import basic.IVector;

final class Polygon implements IPolygon {

    private final List<IPoint> points = new ArrayList<>();
    
    @Override
    public void initWithPoints(IPoint... points) {
        this.points.clear();
        for(IPoint p: points) {
            this.points.add(p);
        }
    }
    
    @Override
    public void initByCopying(IPolygon other) {
        points.clear();
        /*for (IPoint p: other) {
            IPoint q = new Point();
            q.initByCopying(p);
            points.add(q);
        } */
    }

    
    public void move(IVector movement) {
        for(IPoint p: points) {
            p.move(movement);
        }
    }

    
    public void rotate(IPoint pivot, double radian) {
        for(IPoint p: points) {
            p.rotate(pivot, radian);
        }
    }

    
    public Iterator<IPoint> iterator() {
        
        return new Iterator<IPoint>() {
            private int index = 0;
            
            @Override
            public boolean hasNext() {
                return index >= points.size();
            }

            @Override
            public IPoint next() {
                return points.get(index++);
                
            }
        };
    }


	public void initWithCircle() {
		// TODO Auto-generated method stub
		
	}

	
	public void initWithPolygon() {
		// TODO Auto-generated method stub
		
	}

	
	public void setSpeed() {
		// TODO Auto-generated method stub
		
	}

	
	public void setRotation() {
		// TODO Auto-generated method stub
		
	}

	
	public void move() {
		// TODO Auto-generated method stub
		
	}

	
	

	
	public void executeCollision() {
		// TODO Auto-generated method stub
		
	}

	
	public int getXMin() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getYMin() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int getXMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int getYMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IPoint getPoint() {
		// TODO Auto-generated method stub
		return null;
	}
}
