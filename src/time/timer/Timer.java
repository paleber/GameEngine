package time.timer;

final class Timer implements ITimer {
    private ITrigger trigger;
    private int interval;
    private Runner runner;

    private final class Runner implements Runnable {
        private boolean running = true;
        private long last = System.currentTimeMillis();

        private Runner() {
            new Thread(this).start();
        }

        @Override
        public void run() {
            try {
                Thread.sleep(interval);
                while (running) {
                    if (System.currentTimeMillis() > last + interval) {
                        last = System.currentTimeMillis();
                        trigger.onTrigger();
                    }
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                throw new IllegalStateException("Timer interrupted");
            }
        }
    }

    @Override
    public void init(final ITrigger trigger, final int interval) {
        if (interval <= 0) {
            throw new IllegalArgumentException("period <= 0");
        }
        this.trigger = trigger;
        this.interval = interval;
    }

    @Override
    public void start() {
        if (runner != null) {
            throw new IllegalStateException("Timer already running");
        }
        runner = new Runner();
    }

    @Override
    public void stop() {
        if (runner == null) {
            throw new IllegalStateException("Timer not running");
        }
        runner.running = false;
        runner = null;
    }
}