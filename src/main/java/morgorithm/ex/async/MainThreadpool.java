package morgorithm.ex.async;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class MainThreadpool {
    private static List<Shop> shopList = Arrays.asList(
            new Shop("aa"),
            new Shop("bb"),
            new Shop("ba"),
            new Shop("bc"),
            new Shop("cc"),
            new Shop("dd"));

    private final Executor executor = Executors.newFixedThreadPool(Math.min(shopList.size(), 100),
            runnable -> {
                            Thread t = new Thread(runnable);
                            t.setDaemon(true);
                            return t;
                        });

    public static void main(String[] args) {
        MainThreadpool mainThreadpool = new MainThreadpool();
        mainThreadpool.twosecond();
    }

    private void twosecond() {
        long start = System.nanoTime();
        List<Shop> shopList = Arrays.asList(
                new Shop("aa"),
                new Shop("bb"),
                new Shop("ba"),
                new Shop("bc"),
                new Shop("cc"),
                new Shop("dd"));
        final List<CompletableFuture<Double>> completableFutures = shopList.stream()
                .map(s -> CompletableFuture.supplyAsync(s::getPrice, executor))
                .collect(Collectors.toList());

        final List<Double> collect = completableFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
        long finish = (System.nanoTime() - start) / 1_000_000;
        System.out.println("시간2=" + finish);
    }
}
