package time.imp;

import time.ITpfCounter;

public class TpfCounter implements ITpfCounter {

    private long last;
    private double tpf;

    @Override
    public void init() {
        last = System.nanoTime();
    }

    @Override
    public void count() {
        long cur = System.nanoTime();
        tpf = (cur - last) * 1e-6;
        last = cur;
    }

    @Override
    public double getTPF() {
        return tpf;
    }

}
