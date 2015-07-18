package time.source;

public interface ITimeSource {

    long getNanoTime();
    
    void setNanoTime(long nanoTime);
    
}
