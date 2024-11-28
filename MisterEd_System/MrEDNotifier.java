import java.util.ArrayList;
import java.util.List;

// Subject Interface
interface Subject {
    void attach(Observer observer);
    void attachAll(List<? extends Observer> newObservers);
    void detach(Observer observer);
    void notifyObservers();
}

// Concrete Subject Class
public class MrEDNotifier implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    public String getState() {
        return state;
    }

    @Override
    public void attach(Observer observer) {
        observers.add((Observer)observer);
    }

    @Override
    public void attachAll(List<? extends Observer> newObservers) {
        // Add all observers from the provided list to the current observers list
        for (Observer newObserver : newObservers) {
            observers.add((Observer)newObserver);
        }
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}

// Observer Interface
interface Observer {
    void update(String state);
}