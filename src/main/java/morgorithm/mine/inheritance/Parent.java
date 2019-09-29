package morgorithm.mine.inheritance;

public class Parent {

    public void something(){
        System.out.println("parent something");
    }

    public void start(){
        System.out.println("start");
        something();
    }
}
