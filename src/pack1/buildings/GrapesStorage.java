package pack1.buildings;

public class GrapesStorage {

    public static final int MAX_STORAGE_CAPACITY = 100;
    private int grapesInStorage = 0;



    public synchronized void putGrapes (int grapesToPutInStorage){
        while (this.grapesInStorage + grapesToPutInStorage >= MAX_STORAGE_CAPACITY){
            System.out.println(Thread.currentThread().getName() + ": Max storage limit reached!");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.grapesInStorage += grapesToPutInStorage;
        System.out.println(Thread.currentThread().getName() + ": I've picked " + grapesToPutInStorage + " kg. grapes! Total in storage is " + grapesInStorage);
        notifyAll();
    }

    public synchronized int getGrapes (int grapesToGet){
        while (grapesToGet > this.grapesInStorage){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": I've got " + grapesToGet + " kg grapes for Rakiq from the storage!");
        grapesInStorage -= grapesToGet;
        notifyAll();
        return grapesToGet;
    }
}
