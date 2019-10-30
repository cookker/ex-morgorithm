package morgorithm.mine.design.obser;

public interface Subject {
    void registerObserver(Observer o);
    void notifyObservers(String message);
}
