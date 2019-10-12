package morgorithm.mine.fibonacci;

import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Fibonacci {

    //스트림을 이용하여 피보나치 구현..
    public static void main(String[] args) {
        Stream.iterate(new int[]{1, 1}, i -> new int[]{i[1], i[0] + i[1]})
                .limit(10)
                .map(i -> i[0])
                .forEach(System.out::println);
    }
}
