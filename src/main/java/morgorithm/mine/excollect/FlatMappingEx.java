package morgorithm.mine.excollect;

import java.util.*;

import static java.util.stream.Collectors.*;

public class FlatMappingEx {
    public static void main(String[] args) {
        final Map<Type, Set<String>> dishNamesByType = menu.stream()
                .collect(groupingBy(Dish::getType,
                        flatMapping(d -> dishTags.get(d.getName()).stream(),
                                toSet())));

        System.out.println(dishNamesByType);

        final Map<Type, Map<CaloricLevel, List<Dish>>> dishsByTypeCaloricLevel = menu.stream()
                .collect(groupingBy(Dish::getType,
                        groupingBy(dish -> {
                            if (dish.getCalories() <= 400)
                                return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else
                                return CaloricLevel.FAT;
                        }))
                );

        System.out.println(dishsByTypeCaloricLevel);

        final Map<Type, Dish> mostCaloricByType = menu.stream()
                .collect(groupingBy(Dish::getType,
                        collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)
                ));

        System.out.println(mostCaloricByType);



    }

    private static final Map<String, List<String>> dishTags = new HashMap<>();

    static{
        dishTags.put("pork", Arrays.asList("greasy", "salty"));
        dishTags.put("beef", Arrays.asList("salty", "roasted"));
        dishTags.put("chicken", Arrays.asList("fried", "crisp"));
        dishTags.put("french fries", Arrays.asList("greasy", "fried"));
        dishTags.put("seasonal fruit", Arrays.asList("fresh", "natural"));
        dishTags.put("pizza", Arrays.asList("tasty", "salty"));
        dishTags.put("prawns", Arrays.asList("tasty", "roasted"));
        dishTags.put("rice", Arrays.asList("light", "natural"));
    }

    private static final List<Dish> menu;

    static{
        menu = Arrays.asList(
                new Dish("seasonal fruit", true ,120, Type.OTHER),
                new Dish("prawns", false, 300, Type.FISH),
                new Dish("rice", true, 350, Type.OTHER),
                new Dish("chicken", false, 400, Type.MEAT),
                new Dish("french fries", true, 530, Type.OTHER)
        );
    }
}
