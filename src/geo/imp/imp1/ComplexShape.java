package geo.imp.imp1;

abstract class ComplexShape {

    protected final void addAsParent(Point child) {
        child.addParent(this);
    }

    protected final void removeAsParent(Point child) {
        if(child != null) {
            child.removeParent(this);
        }
    }
    
    protected abstract void update();
       
}
