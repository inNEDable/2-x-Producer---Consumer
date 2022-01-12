package pack1.buildings;

import pack1.workers.RakiaMaster;

public class RakiaDestilery {

    private final int MAX_BOTTLES_CAPACITY = 50;
    private int rakiaBottles;



    public synchronized void makeBottleOfRakia() {
        while (rakiaBottles + 1 > MAX_BOTTLES_CAPACITY){
            System.out.println(Thread.currentThread().getName() + " : Can't make more rakia - No space for it in the winery!");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.rakiaBottles++;
        System.out.println(Thread.currentThread().getName() + " : Made A bottle of rakia and added it to the winery");
        notifyAll();
    }

    public synchronized int getRakiaForDelivery(int bottlesToGet){

        while (rakiaBottles < bottlesToGet){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.rakiaBottles -= bottlesToGet;
        notifyAll();
        return bottlesToGet;
    }
}
