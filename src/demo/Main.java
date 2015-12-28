package demo;

/*

public class Main implements ITrigger {

    private static final Injector INJECTOR = Guice.createInjector(
            new FrameModule(), new TimerModule(), new GeoModule(),
            new TpfCounterModule(), new SystemTimeSourceModule());

    private final ITimer logicTimer = INJECTOR.getInstance(ITimer.class);
    private final ITpfCounter tpfCounter = INJECTOR
            .getInstance(ITpfCounter.class);

    private final List<IBall> balls = new LinkedList<>();
    private final List<IWall> walls = new LinkedList<>();

    private final JPanel content = new JPanel() {

        private static final long serialVersionUID = 1L;

        public void paint(Graphics graphics) {

            Graphics2D g = (Graphics2D) graphics;

            g.addRenderingHints(new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON));

            g.addRenderingHints(new RenderingHints(
                    RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR));

            for (IBall b : balls) {

                IPoint mid = b.getShape().getMid();
                double r = b.getShape().getRadius();

                g.fillOval((int) (mid.getX() - r), (int) (mid.getY() - r),
                        (int) (2 * r), (int) (2 * r));
            }

            for (IWall w : walls) {
                IPolygon poly = w.getShape();
                int[] x = new int[poly.getNumPoints()];
                int[] y = new int[poly.getNumPoints()];

                Iterator<IPoint> it = poly.getPointIterator();
                for (int i = 0; i < x.length; i++) {
                    IPoint p = it.next();

                    x[i] = (int) p.getX();
                    y[i] = (int) p.getY();
                }

                g.fillPolygon(x, y, x.length);
            }



        }
    };

    public Main() {

        IFrame frame = INJECTOR.getInstance(IFrame.class);
        frame.setTitle("Test-Frame");
        frame.setContentPane(content);

        tpfCounter.init();

        // Ball
        IBall b = new Ball();
        IPoint p = INJECTOR.getInstance(IPoint.class);
        p.set(100, 100);
        b.init(p, 20, 20, tpfCounter);
        balls.add(b);

        // Wall TOP
        IWall w = new Wall();
        IPolygon poly = INJECTOR.getInstance(IPolygon.class);
        IPoint[] points = new IPoint[4];
        for (int i = 0; i < points.length; i++) {
            points[i] = INJECTOR.getInstance(IPoint.class);
        }
        points[0].set(0, 0);
        points[1].set(800, 0);
        points[2].set(800, 50);
        points[3].set(0, 50);
        poly.setPoints(points);
        w.init(poly);
        walls.add(w);

        // Wall Bot
        w = new Wall();
        poly = INJECTOR.getInstance(IPolygon.class);
        points = new IPoint[4];
        for (int i = 0; i < points.length; i++) {
            points[i] = INJECTOR.getInstance(IPoint.class);
        }
        points[0].set(0, 550);
        points[1].set(800, 550);
        points[2].set(800, 600);
        points[3].set(0, 600);
        poly.setPoints(points);
        w.init(poly);
        walls.add(w);
        
        // Wall Left
        w = new Wall();
        poly = INJECTOR.getInstance(IPolygon.class);
        points = new IPoint[4];
        for (int i = 0; i < points.length; i++) {
            points[i] = INJECTOR.getInstance(IPoint.class);
        }
        points[0].set(0, 50);
        points[1].set(50, 50);
        points[2].set(50, 550);
        points[3].set(0, 550);
        poly.setPoints(points);
        w.init(poly);
        walls.add(w);
        
        // Wall Right
        w = new Wall();
        poly = INJECTOR.getInstance(IPolygon.class);
        points = new IPoint[4];
        for (int i = 0; i < points.length; i++) {
            points[i] = INJECTOR.getInstance(IPoint.class);
        }
        points[0].set(750, 50);
        points[1].set(800, 50);
        points[2].set(800, 550);
        points[3].set(750, 550);
        poly.setPoints(points);
        w.init(poly);
        walls.add(w);

        // Timer
        logicTimer.init(this, 10);
        logicTimer.start();

    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void onTrigger() {

        tpfCounter.count();
        for (IBall b : balls) {
            b.move();
        }
        
        for (IBall b: balls) {
            
            for (IWall w: walls) {
                
                // TODO, erst alles abarbeiten, dann ausf�hren
                if(Collision.checkBoundingBoxes(b.getBoundingBox(), w.getBoundingBox())) {
                    b.collideWith(w.getShape());
                }
                
            }
            
        }

    }

}

*/