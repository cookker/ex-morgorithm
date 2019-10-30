package morgorithm.ex.async;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompletableAsync2 {

    public static void main(String[] args) {
        CompletableAsync2 c = new CompletableAsync2();
        long start = System.nanoTime();
        final Future<Double> myproduct = c.getPriceAsync("myproduct");
        long invocation = (System.nanoTime() - start) / 1_000_000;
        System.out.println("시간1=" + invocation);

        try {
            System.out.println(myproduct.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        long finish = (System.nanoTime() - start) / 1_000_000;
        System.out.println("시간2=" + finish);
    }

    public Future<Double> getPriceAsync(String product){
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    public double calculatePrice(String product){
        try{
            Thread.sleep(1000L);
        }catch (Exception ignore){
            throw new RuntimeException(ignore);
        }
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
