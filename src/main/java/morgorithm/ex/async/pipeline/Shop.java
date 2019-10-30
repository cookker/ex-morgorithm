package morgorithm.ex.async.pipeline;

import java.util.Random;

public class Shop {

    private String shopName;

    public Shop(String shopName) {
        this.shopName = shopName;
    }

    public String getPrice(String product){
        double price = calculatePrice(product);
        Code code = Code.values()[new Random().nextInt(Code.values().length)];

        return String.format("%s:%.2f:%s", this.shopName, price, code);
    }

    public double calculatePrice(String product){
        delay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void delay(){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
