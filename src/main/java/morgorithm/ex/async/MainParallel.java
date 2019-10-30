package morgorithm.ex.async;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class MainParallel {

    public static void main(String[] args) {
        twosecond();
    }

    private static void onesecond() {
        long start = System.nanoTime();
        List<Shop> shopList = Arrays.asList(
                new Shop("aa"),
                new Shop("bb"),
                new Shop("cc"),
                new Shop("dd"));
        shopList.stream()
                .parallel()
                .map(Shop::getPrice)
                .forEach(System.out::println);

        long finish = (System.nanoTime() - start) / 1_000_000;
        System.out.println("시간2=" + finish);
    }

    private static void twosecond() {
        long start = System.nanoTime();
        List<Shop> shopList = Arrays.asList(
                new Shop("aa"),
                new Shop("bb"),
//                new Shop("ba"),
//                new Shop("bc"),
                new Shop("cc"),
                new Shop("dd"));
        final List<CompletableFuture<Double>> completableFutures = shopList.stream()
                .map(s -> CompletableFuture.supplyAsync(s::getPrice))
                .collect(Collectors.toList());

        final List<Double> collect = completableFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
        long finish = (System.nanoTime() - start) / 1_000_000;
        System.out.println("시간2=" + finish);
    }

    private static void foursecond() {
        long start = System.nanoTime();
        List<Shop> shopList = Arrays.asList(
                new Shop("aa"),
                new Shop("bb"),
                new Shop("cc"),
                new Shop("dd"));

        shopList.stream()
                .map(Shop::getPriceAsync)
                .map(m -> {
                    try {
                        return m.get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                })
                .forEach(System.out::println);


        long finish = (System.nanoTime() - start) / 1_000_000;
        System.out.println("시간2=" + finish);
    }
}
