package morgorithm.ex.collect;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListEq {

    public static void main(String[] args) {
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(new Student("a", 1));
        studentSet.add(new Student("b", 1));
        studentSet.add(new Student("a", 2));
        studentSet.add(new Student("a", 1));
        studentSet.add(new Student("b", 2));

        studentSet.forEach(System.out::println);
    }
}
