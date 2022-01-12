package pack1.workers;

import pack1.buildings.RakiaDestilery;
import pack1.buildings.RakiaShop;

public class ShopSupplier implements Runnable{

    private RakiaDestilery rakiaDestilery;
    private RakiaShop rakiaShop;

    public ShopSupplier(RakiaDestilery rakiaDestilery, RakiaShop rakiaShop) {
        this.rakiaDestilery = rakiaDestilery;
        this.rakiaShop = rakiaShop;
    }

    @Override
    public void run() {

    }
}
