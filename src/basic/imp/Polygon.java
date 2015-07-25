package basic.imp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import basic.IPoint;
import basic.IPolygon;
import basic.IVector;
import sprite.ICollider;

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
        for (IPoint p: other) {
            IPoint q = new Point();
            q.initByCopying(p);
            points.add(q);
        }
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

    @Override
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

	@Override
	public void initWithCircle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initWithPolygon() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSpeed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRotation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkCollision(ICollider collider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executeCollision() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getXMin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getYMin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getXMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getYMax() {
		// TODO Auto-generated method stub
		return 0;
	}
}
