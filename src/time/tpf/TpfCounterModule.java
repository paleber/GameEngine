package time.tpf;

import javax.inject.Inject;

import time.source.ITimeSource;

import com.google.inject.AbstractModule;

public final class TpfCounterModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ITpfCounter.class).to(TpfCounter.class);
    }

}

class TpfCounter implements ITpfCounter {

    private long last;
    private double tpf;
    
    private final ITimeSource timeSource;    

    @Inject
    public TpfCounter(ITimeSource timeSource) {
        this.timeSource = timeSource;
    }

    @Override
    public void init() {
        last = timeSource.getNanoTime();
    }

    @Override
    public void count() {
        long cur = timeSource.getNanoTime();
        tpf = (cur - last) * 1e-6;
        last = cur;
    }

    @Override
    public double getTPF() {
        return tpf;
    }

}
