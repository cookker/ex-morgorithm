package morgorithm.mine.design.obser;

import java.util.ArrayList;
import java.util.List;

public class Feed implements Subject {

    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void notifyObservers(String message) {
        observerList.forEach(o -> o.notify(message));
    }
}
