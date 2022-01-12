package pack1.workers;

import pack1.buildings.GrapesStorage;
import pack1.buildings.RakiaDestilery;

public class RakiaMaster implements Runnable {
    public static final int GRAPES_NEEDED_FOR_RAKIA_BOTTLE = 10;
    GrapesStorage grapesStorage;
    RakiaDestilery rakiaDestilery;

    public RakiaMaster(GrapesStorage grapesStorage, RakiaDestilery rakiaDestilery) {
        this.grapesStorage = grapesStorage;
        this.rakiaDestilery = rakiaDestilery;
    }

    @Override
    public void run() {
        while (true) {
            grapesStorage.getGrapes(GRAPES_NEEDED_FOR_RAKIA_BOTTLE);
            rakiaDestilery.makeBottleOfRakia();
        }
    }
}
