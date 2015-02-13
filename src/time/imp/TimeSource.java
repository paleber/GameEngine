package time.imp;

import time.ITimeSource;

public class TimeSource implements ITimeSource{

    @Override
    public long getNanoTime() {
        return System.nanoTime();
    }

    @Override
    public void setNanoTime(final long nanoTime) {
        throw new UnsupportedOperationException();
    }

}
