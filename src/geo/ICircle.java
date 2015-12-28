package geo;


/*
public interface ICircleNew {

    void init(IPoint mid, double radius);

    IPoint getMid();

    double getRadius(); */


    //void setMid(IPoint point);



    //void setRadius(double radius);



    // void init(double x, double y, double radius);

//}



/**
 * Interface of Circle.
 */
public interface ICircle { //extends geo2.IShape {

    /**
     * Get the mid.
     *
     * @return mid
     */
    IPoint getMid();

    /**
     * Get the radius.
     *
     * @return radius
     */
    double getRadius();

}