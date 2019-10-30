package morgorithm.mine.defaultmethod;

public interface A {
    default void hello(){
        System.out.println("A");
    }
}
