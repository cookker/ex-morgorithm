package morgorithm.mine.defaultmethod;

public interface Some {
    default void hello(){
        System.out.println("some");
    }
}
