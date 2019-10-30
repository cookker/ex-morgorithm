package morgorithm.mine.defaultmethod;

public interface SomeThingA extends Some {

    @Override
    default void hello() {
        System.out.println("SomethingA");
    }
}
