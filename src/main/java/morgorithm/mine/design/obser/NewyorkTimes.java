package morgorithm.mine.design.obser;

public class NewyorkTimes implements Observer {
    @Override
    public void notify(String message) {
        System.out.println(message);

    }
}
