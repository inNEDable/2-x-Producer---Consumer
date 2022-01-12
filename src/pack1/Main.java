package pack1;

import pack1.buildings.GrapesStorage;
import pack1.buildings.RakiaDestilery;
import pack1.workers.Gatherer;
import pack1.workers.RakiaMaster;

public class Main {

    public static void main(String[] args) {

        GrapesStorage grapesStorage = new GrapesStorage();
        RakiaDestilery rakiaDestilery = new RakiaDestilery();

        for (int i = 0; i < 4; i++) {
            Thread gatherer = new Thread(new Gatherer(grapesStorage), "Gatherer " + (i+1));
            gatherer.start();
        }

        for (int i = 0; i < 2; i++) {
            Thread rakiaMaster = new Thread(new RakiaMaster(grapesStorage, rakiaDestilery), "Rakia Master " + (i + 1));
            rakiaMaster.start();
        }


    }
}
