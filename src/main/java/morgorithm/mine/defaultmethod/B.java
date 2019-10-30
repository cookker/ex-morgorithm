package morgorithm.mine.defaultmethod;

public interface B {
    default void hello() {
        System.out.println("B");
    }
}
