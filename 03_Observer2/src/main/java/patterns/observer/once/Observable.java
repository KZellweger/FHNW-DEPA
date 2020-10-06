package patterns.observer.once;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Observable {

	private final List<Observer> observers = new CopyOnWriteArrayList<>(); //Creates internal a copy of the collection and therfore allows a change during iteration.

	public void addObserver(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	protected void notifyObservers() {
		for (Observer obs : observers) {
			obs.update(this);
		}
		// observers.forEach(obs -> obs.update(this));
	}
}
