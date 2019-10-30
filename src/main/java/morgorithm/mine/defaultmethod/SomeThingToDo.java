package morgorithm.mine.defaultmethod;

public class SomeThingToDo implements SomeThingA, SomeThingB {

    public static void main(String[] args) {
        SomeThingToDo someThingToDo = new SomeThingToDo();
        someThingToDo.hello();
    }

    @Override
    public void hello() {

    }
}
