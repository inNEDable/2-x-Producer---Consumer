package pack1.workers;

import pack1.buildings.GrapesStorage;

import java.util.Random;

public class Gatherer implements Runnable{

    GrapesStorage grapesStorage;

    public Gatherer(GrapesStorage grapesStorage) {
        this.grapesStorage = grapesStorage;
    }

    @Override
    public void run() {
        while (true) {
            int grapesToGather = new Random().nextInt(3)+1;
            this.grapesStorage.putGrapes(grapesToGather);
        }
    }
}
