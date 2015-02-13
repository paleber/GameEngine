package time.fake;

import time.ITimeSource;

public class FakeTimeSource implements ITimeSource {

    private long nanoTime;
    
    @Override
    public long getNanoTime() {
        return nanoTime;
    }

    @Override
    public void setNanoTime(final long nanoTime) {
        this.nanoTime = nanoTime;
    }

}
