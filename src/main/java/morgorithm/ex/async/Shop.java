package morgorithm.ex.async;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

    private String product;

    public Shop(String product) {
        this.product = product;
    }

    public Future<Double> getPriceAsync(){
        return CompletableFuture.supplyAsync(() -> calculatePrice(this.product));
    }

    public double getPrice(){
        return calculatePrice(this.product);
    }

    private double calculatePrice(String product){
        try{
            Thread.sleep(1000L);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
