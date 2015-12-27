package siedler.model;

public class Game {

    private Intersection[] intersections;
    private Path[] path;
    private Terrain[] terrain;

    public Game() {
        //Intersection inter = new Intersection();
    }




    // Runde:

    // Würfeln -> Rohstoffe ziehen --> Feld auf Punkt

    // Bauen -> Straße   --> Benachbarte Straßen
    //       -> Siedlung --> Benachbarte Straße auf Punkte auf andere benachbarte Straßen

}
