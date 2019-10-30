package morgorithm.mine.excollect.maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Map.entry;

public class MapEx {

    public static void main(String[] args) {
        merge();
        remove();
        max();
    }

    private static void max() {
        final Map<String, Integer> map = Map.of("a", 1, "b", 2, "c", 30, "d", 4, "e", 5);
        ConcurrentHashMap<String, Integer> conMap = new ConcurrentHashMap<>(map);

        final int max = conMap.reduceValuesToInt(1,  i -> i, 1, Integer::max);

        //size()는 int이고 mappingCount는 long이다.
        final long size = conMap.mappingCount();

        System.out.println(max);
    }

    private static void remove() {
        final List<Integer> ints = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());


        for (int i = 0; i < ints.size(); i++) {

            if( i == 1){
                ints.remove(i);
            }
        }
        System.out.println(ints);

//        for (Integer anInt : ints) {
//            if( anInt == 1){
//                ints.remove(anInt);
//            }
//        }
//
//        System.out.println(ints);
    }

    private static void merge() {
        final Map<String, String> dishes1
                = Map.ofEntries(entry("spam", "고추장찌개"), entry("삼겹살", "김치찜"));


        final Map<String, String> dishes2
                = Map.ofEntries(entry("고구마", "맛탕"), entry("삼겹살", "보쌈"));

        Map<String, String> mergedDish = new HashMap<>(dishes1);

        dishes2.forEach((k,v) -> {
            mergedDish.merge(k, v, (dishname, dishYori) -> v + dishYori);
        });

        System.out.println(mergedDish);
    }
}
