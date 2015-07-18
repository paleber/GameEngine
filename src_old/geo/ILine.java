package geo;


public interface ILine  {

    IPoint getStart();

    IPoint getEnd();
    
    void setPoints(IPoint start, IPoint end);
    
}


