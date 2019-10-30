package morgorithm.mine.defaultmethod;

public interface SomeThingB extends Some {

    @Override
    default void hello() {
        System.out.println("SomeThingB");
    }
}
