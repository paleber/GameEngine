package time;

public interface ITimeSource {

    long getNanoTime();
    
    void setNanoTime(long nanoTime);
    
}
